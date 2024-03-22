package frc.robot.command.autolime;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsytems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose3d;

public class AutoAlignTagsDrive extends Command {

    private SwerveSubsystem swerveSub;
    private ProfiledPIDController xPID;
    private ProfiledPIDController distancePID;
    private boolean turnOff = false;
    private double backTagID;
    private double frontTagID;
    private int tagChoice;
    // private static double rot;
    // private static double yOff;
    private Joystick primaryStick;

    // static double getZontal() {
    //     return (LimelightHelpers.getTX("limelight-back") / 27);
    //     // return (x.getDouble(160)/160)-1;
    //     // horizontal offset
    // }

    final Pose3d getSpace() {
        return (LimelightHelpers.getTargetPose3d_RobotSpace("limelight-back"));
        // return (x.getDouble(160)/160)-1;
        // whatever the distance is
        // returns the specific distance value we want so we can pid it???
        // why is everything so
    }

    public static boolean speakerAimReady() {
        return LimelightHelpers.getTV("limelight-back");
    }

    public AutoAlignTagsDrive(SwerveSubsystem swerveSub, Joystick primaryStick) {
        this.primaryStick = primaryStick;

        // ignore me bbg
        // make tr

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        xPID = new ProfiledPIDController(3*.6, 0.8*.5, .8*.125,
                new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 3/1.5));
        distancePID = new ProfiledPIDController(3*.6, .8*.5, .8*.125,
                new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 3/1.5));

        // the robot cant like run into the limelight he needs to be close but not too
        // close omg im gonna die
        distancePID.setGoal(1.5);
        distancePID.setIntegratorRange(-15, 15);
        xPID.setIntegratorRange(-15, 15);

    }

    public boolean aligned(){
        if (!LimelightHelpers.getTV("limelight-back")) {
            return false;
        }
        if((getSpace().getZ()< 1.55 && getSpace().getZ() > 1.4) && (Math.abs(getSpace().getX()) < 0.2)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void initialize() {
        distancePID.reset(1.5);
        xPID.reset(0);

    }

    @Override
    public void execute() {
        var xSpeed = (MathUtil.applyDeadband(-primaryStick.getY(), 0.1)) * .5;
        var ySpeed = (MathUtil.applyDeadband(-primaryStick.getX(), 0.1)) * .5;
        var manualRot = (MathUtil.applyDeadband(-primaryStick.getTwist(), 0.1)) * .1;

        if (LimelightHelpers.getTV("limelight-back")) {
            var id = LimelightHelpers.getFiducialID("limelight-back");
            // if (DriverStation.isFMSAttached()){
            //     if (!(id == 7 || id == 4)) { return; }
            // }
            // backTagID = LimelightHelpers.getFiducialID("limelight-back");
                        // double xOff = -xPID.calculate(getZontal());
                        var rot = xPID.calculate(getSpace().getX());
                        rot = MathUtil.clamp(rot, -DriveConstants.MaxVelocityMetersPerSecond/5, DriveConstants.MaxVelocityMetersPerSecond/5);
                        // var xOff = 0.0;

                        var df = NetworkTableInstance.getDefault();
                        df.getEntry("/Shuffleboard/Tune/LimeZ").setDouble(getSpace().getZ());
                        double yOff = distancePID.calculate(getSpace().getZ());
                        yOff = MathUtil.clamp(yOff, -DriveConstants.MaxVelocityMetersPerSecond/3.5, DriveConstants.MaxVelocityMetersPerSecond/3.5);
                        df.getEntry("/Shuffleboard/Tune/DistancePID").setDouble(yOff);
                        // figure out how to use an array, which value of the array am i using??

                        // double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff/DriveConstants.MaxVelocityMetersPerSecond, 0/DriveConstants.MaxVelocityMetersPerSecond + ySpeed, rot/DriveConstants.MaxAngularVelocityRadiansPerSecond, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
            }
        
            // else if(LimelightHelpers.getTV("limelight-front")){
            //     if(!LimelightHelpers.getTV("limelight-back")){
            //         swerveSub.drive(0, 0, 0.25, false);
            //     }
            // }
            else {
                swerveSub.drive(xSpeed, ySpeed, manualRot, false);
            }
    }

    @Override
    public void end(boolean interrupted) {
        swerveSub.drive(0, 0, 0, false, 0, 0);
    }
}
