package frc.robot.command;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.LimelightHelpers;
import frc.robot.subsytems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class LimelightlightDrive extends Command {

    private SwerveSubsystem swerveSub;
    private PIDController turnPID;
    private PIDController distancePID;
    private XboxController primaryController;

    public LimelightlightDrive(SwerveSubsystem swerveSub, XboxController primaryController) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.limelight = addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.primaryController = primaryController;

    }

    @Override
    public void execute() {
        if (LimelightHelpers.isTargetDetected()) {
            double xOff = turnPID.calculate(LimelightHelpers.getXOffset());
        }
    }

}
