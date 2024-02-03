package frc.robot.subsytems;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

//add motor channel numbers later
public class SwerveSubsystem extends SubsystemBase {

    private final SlewRateLimiter xRateLimiter = new SlewRateLimiter(2);
    private final SlewRateLimiter yRateLimiter = new SlewRateLimiter(2);
    private final SlewRateLimiter rotRateLimiter = new SlewRateLimiter(2);

    private final Translation2d frontLeftLocation = new Translation2d(0.381, 0.381);
    private final Translation2d frontRightLocation = new Translation2d(0.381, -0.381);
    private final Translation2d backLeftLocation = new Translation2d(-0.381, 0.381);
    private final Translation2d backRightLocation = new Translation2d(-0.381, -0.381);

    private final SwerveModule fLSwerve = new SwerveModule(15, 14, 20, true, true, -0.115);
    private final SwerveModule fRSwerve = new SwerveModule(13, 12, 19, true, true, 0.051);
    private final SwerveModule bLSwerve = new SwerveModule(17, 16, 21, true, true, -0.234);
    private final SwerveModule bRSwerve = new SwerveModule(11, 10, 18, true, true, -0.287);

    Joystick primaryJoy = new Joystick(0);
    Joystick SecondJoy = new Joystick(1);

    private static AHRS gyro = new AHRS(SPI.Port.kMXP);

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
            frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation);

    public void drive(double xPercent, double yPercent, double rotPercent, boolean fieldRelative) {
        drive(xPercent, yPercent, rotPercent, fieldRelative, 0, 0);
    }

    public void drive(double xPercent, double yPercent, double rotPercent, boolean fieldRelative, double a, double b) {

        var xSpeed = xRateLimiter.calculate(xPercent) * Constants.DriveConstants.MaxVelocityMetersPerSecond;
        var ySpeed = yRateLimiter.calculate(yPercent) * Constants.DriveConstants.MaxVelocityMetersPerSecond;
        var rot = rotRateLimiter.calculate(rotPercent) * Constants.DriveConstants.MaxAngularVelocityRadiansPerSecond;

        if (!primaryJoy.getTrigger()) {
            xSpeed *= 0.5;
            ySpeed *= 0.5;
            rot *= 0.2;
        } else {
            rot *= 0.5;
        }

        // while(primaryJoy.getRawButton(7)){
        // xSpeed *= 0.75;
        // ySpeed *= 0.75;
        // rot *= 0.2;
        // }
        ChassisSpeeds chasSpeed = fieldRelative
                ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rot, gyro.getRotation2d())
                : new ChassisSpeeds(xSpeed, ySpeed, rot);

        var swerveModuleStates = kinematics.toSwerveModuleStates(chasSpeed);

        // TODO: DEFINE MAX SPEED
        var swerveModuleStates2 = DriveConstants.kinematics.toSwerveModuleStates(
                ChassisSpeeds.discretize(chasSpeed, 0.2),
                new Translation2d(DriveConstants.kTrackBaseMeters * a * 1.5,
                        DriveConstants.kTrackWidthMeters * b * 1.5));

        SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates,
                Constants.DriveConstants.MaxVelocityMetersPerSecond);

        fLSwerve.setDesiredState(swerveModuleStates[0]);
        fRSwerve.setDesiredState(swerveModuleStates[1]);
        bLSwerve.setDesiredState(swerveModuleStates[2]);
        bRSwerve.setDesiredState(swerveModuleStates[3]);

    }

    public static void zeroYaw() {
        gyro.zeroYaw();
    }

}