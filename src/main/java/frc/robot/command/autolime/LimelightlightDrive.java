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
    private PIDController xPID;
    private PIDController stancePID;
    boolean turnOff = false;
    private XboxController primaryController;

    final double getZontal() {
        return (LimelightHelpers.getTX("") / 27);
        // return (x.getDouble(160)/160)-1;
        //horizontal offset
    }
    final double[] getStance() {
        return (LimelightHelpers.getTargetPose_RobotSpace(""));
        // return (x.getDouble(160)/160)-1;
        //whatever the distance is
        //returns the specific distance value we want so we can pid it???
        //why is everything so 
    }
    public LimelightlightDrive(SwerveSubsystem swerveSub, boolean turnOff, XboxController primaryController) {

        // ignore me bbg
        // make tr

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.turnOff = turnOff;
        this.primaryController = primaryController;
        xPID = new PIDController(0.0525, 0.009, 0.0001);
        stancePID = new PIDController(0,0,0);

    }

    @Override
    public void execute() {
        if (LimelightHelpers.getTV("")) {

            double xOff = xPID.calculate(getZontal());

            // double yOff = stancePID.calculate(getStance(1));
            //figure out how to use an array, which value of the array am i using??

            System.out.println(getStance());
            
            swerveSub.drive(xOff, 0, 0, false);
            //is x forward and backward??
            //wtf
            //is y forward?
        }
    }

}
