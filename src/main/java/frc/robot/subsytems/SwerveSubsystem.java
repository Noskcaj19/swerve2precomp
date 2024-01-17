package frc.robot.subsytems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


//add motor channel numbers later
public class SwerveSubsystem extends SubsystemBase {

    private final Translation2d frontLeftLocation = new Translation2d(0.381, 0.381);
    private final Translation2d frontRightLocation = new Translation2d(0.381, -0.381);
    private final Translation2d backLeftLocation = new Translation2d(-0.381, 0.381);
    private final Translation2d backRightLocation = new Translation2d(-0.381, -0.381);

    private final SwerveModule fLSwerve = new SwerveModule(15, 14, 20, true, true, -0.247);
    private final SwerveModule fRSwerve = new SwerveModule(13, 12, 19, true, true, -.437);
    private final SwerveModule bLSwerve = new SwerveModule(17, 16, 21, true, true,0.325);
    private final SwerveModule bRSwerve = new SwerveModule(11, 10, 18, true, true, -0.072);

    XboxController primaryController = new XboxController(0);
    XboxController secondaryController = new XboxController(1);

    private static AHRS gyro = new AHRS(SPI.Port.kMXP);

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
            frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation);

    public void drive(double xPercent, double yPercent, double rotPercent, boolean fieldRelative) {
        var xSpeed = xPercent * Constants.DriveConstants.MaxVelocityMetersPerSecond;
        var ySpeed = yPercent * Constants.DriveConstants.MaxVelocityMetersPerSecond;
        var rot = rotPercent * Constants.DriveConstants.MaxAngularVelocityRadiansPerSecond;
        var swerveModuleStates = kinematics.toSwerveModuleStates(
                fieldRelative
                        ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rot, gyro.getRotation2d())
                        : new ChassisSpeeds(xSpeed, ySpeed, rot));
        // TODO: DEFINE MAX SPEED
        SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates, Constants.DriveConstants.MaxVelocityMetersPerSecond);
        fLSwerve.setDesiredState(swerveModuleStates[0]);
        fRSwerve.setDesiredState(swerveModuleStates[1]);
        bLSwerve.setDesiredState(swerveModuleStates[2]);
        bRSwerve.setDesiredState(swerveModuleStates[3]);
    }

    public static void zeroYaw() {
        gyro.zeroYaw();
    }

}