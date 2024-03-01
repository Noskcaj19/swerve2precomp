package frc.robot.command.autolime;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.LimelightHelpers;
import frc.robot.subsytems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;

public class AutoAlignTags extends Command {

    private SwerveSubsystem swerveSub;
    private ProfiledPIDController xPID;
    private ProfiledPIDController distancePID;
    private boolean turnOff = false;
    private double backTagID;
    private double frontTagID;
    private int tagChoice;

    final double getZontal() {
        return (LimelightHelpers.getTX("") / 27);
        // return (x.getDouble(160)/160)-1;
        // horizontal offset
    }

    final double getSpace(int index) {
        return (LimelightHelpers.getTargetPose_RobotSpace("")[index]);
        // return (x.getDouble(160)/160)-1;
        // whatever the distance is
        // returns the specific distance value we want so we can pid it???
        // why is everything so
    }

    public AutoAlignTags(SwerveSubsystem swerveSub, int tagChoice) {

        // ignore me bbg
        // make tr

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        xPID = new ProfiledPIDController(1.1, 0, 0,
                new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 2));
        distancePID = new ProfiledPIDController(1.1, 0, 0,
                new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 2));

        // the robot cant like run into the limelight he needs to be close but not too
        // close omg im gonna die
        distancePID.setGoal(new State(2, 0));

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (LimelightHelpers.getTV("limelight-back")) {

            backTagID = LimelightHelpers.getFiducialID("limelight-back");
            switch(tagChoice) {
                case 1:
                //speaker center
                    if (backTagID == 4.0 || backTagID == 7.0) {

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    } else {
                        swerveSub.drive(0, 0, 0, false);
                    }
                case 2:
                //speaker side
                    if (backTagID == 3.0 || backTagID == 8.0) {

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    } else {
                        swerveSub.drive(0, 0, 0, false);
                    }
                case 3:
                //amp
                    if (backTagID == 5.0 || backTagID == 6.0) {

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    } else {
                        swerveSub.drive(0, 0, 0, false);
                    }
                case 4:
                //humanplayer
                    if (backTagID == 1.0 || backTagID == 9.0) {

                        xPID.setGoal(new State(0.5, 0));

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    } else if(backTagID == 2.0 || backTagID == 10.0){
                        xPID.setGoal(new State(-0.5, 0));

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    }
                    else {
                        swerveSub.drive(0, 0, 0, false);
                    }
                case 5:
                //climb
                    if (backTagID == 11.0 || backTagID == 16.0) {

                        double xOff = xPID.calculate(getZontal());

                        //
                        double yOff = -distancePID.calculate(getSpace(2));
                        // figure out how to use an array, which value of the array am i using??

                        double rot = -distancePID.calculate(getSpace(4));

                        // how do i set a different goal for the distance

                        // System.out.println(getStance());

                        swerveSub.drive(yOff, xOff, 0, false);
                        // is x forward and backward??
                        // wtf
                        // is y forward?
                    } else {
                        swerveSub.drive(0, 0, 0, false);
                    }
                    
            }
        } else if (LimelightHelpers.getTV("limelight-front")){
            frontTagID = LimelightHelpers.getFiducialID("limelight-front");
            if(/*detectsnote*/true) {
                double xOff = xPID.calculate(getZontal());

                //
                double yOff = -distancePID.calculate(getSpace(2));
                // figure out how to use an array, which value of the array am i using??

                double rot = -distancePID.calculate(getSpace(4));

                // how do i set a different goal for the distance

                // System.out.println(getStance());

                swerveSub.drive(yOff, xOff, 0, false);
                // is x forward and backward??
                // wtf
                // is y forward?
            } else {
                swerveSub.drive(0, 0, 0, false);
            }
        }
        
        else {
            swerveSub.drive(0, 0, 0, false);
        }
    }

}
