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
    private PIDController turnPID;
    private PIDController distancePID;
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
    }
    public LimelightlightDrive(SwerveSubsystem swerveSub, boolean turnOff, XboxController primaryController) {

        // ignore me bbg
        // make tr

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.turnOff = turnOff;
        this.primaryController = primaryController;
        turnPID = new PIDController(0.0525, 0.009, 0.0001);
    }

    @Override
    public void execute() {
        if (LimelightHelpers.getTV("")) {

            double xOff = turnPID.calculate(getZontal());

            

            swerveSub.drive(0, xOff, 0, false);
        }
    }

}
