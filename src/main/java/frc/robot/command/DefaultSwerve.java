package frc.robot.command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.*;

public class DefaultSwerve extends Command {

    private XboxController primaryController;
    private SwerveSubsystem swerveSub;

    public DefaultSwerve(XboxController primaryController, SwerveSubsystem swerveSub) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.primaryController = primaryController;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        // swerve stuff goes here
        //xspeed is xbox controller left joystick yspeed is also left joystick and rotation is right joystick 
        swerveSub.drive(
            -primaryController.getLeftX(), 
            -primaryController.getLeftY(), 
            -primaryController.getRightX(),
            true);

        if (primaryController.getXButtonPressed()) {
            SwerveSubsystem.zeroYaw();
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
