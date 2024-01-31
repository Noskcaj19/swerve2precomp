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

public class LimelightlightDrive extends Command {

    private SwerveSubsystem swerveSub;
    private ProfiledPIDController xPID;
    private ProfiledPIDController stancePID;
    boolean turnOff = false;

    final double getZontal() {
        return (LimelightHelpers.getTX("") / 27);
        // return (x.getDouble(160)/160)-1;
        //horizontal offset
    }
    final double getSpace(int index) {
        return (LimelightHelpers.getTargetPose_RobotSpace("")[index]);
        // return (x.getDouble(160)/160)-1;
        //whatever the distance is
        //returns the specific distance value we want so we can pid it???
        //why is everything so 
    }
    public LimelightlightDrive(SwerveSubsystem swerveSub) {

        // ignore me bbg
        // make tr

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        xPID = new ProfiledPIDController(1.1, 0, 0, new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 2));
        stancePID = new ProfiledPIDController(1.1,0,0, new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 2));

        //the robot cant like run into the limelight he needs to be close but not too close omg im gonna die
        stancePID.setGoal(new State(2,0));

    }

    @Override
    public void execute() {
        if (LimelightHelpers.getTV("")) {

            double xOff = xPID.calculate(getZontal());

            double yOff = -stancePID.calculate(getSpace(2));
            //figure out how to use an array, which value of the array am i using??

            double rot = -stancePID.calculate(getSpace(4));



            
            //how do i set a different goal for the distance

            // System.out.println(getStance());
            
            swerveSub.drive(yOff, xOff, 0, false);
            //is x forward and backward??
            //wtf
            //is y forward?
        }
        else{
            swerveSub.drive(0, 0, 0, false);
        }
    }

}
