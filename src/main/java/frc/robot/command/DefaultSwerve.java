package frc.robot.command;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.*;

public class DefaultSwerve extends Command {

    private Joystick joy;
    private SwerveSubsystem swerveSub;
    Boolean slow = false;

    public DefaultSwerve(Joystick joy, SwerveSubsystem swerveSub) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.joy = joy;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        // swerve stuff goes here
        //xspeed is xbox controller left joystick yspeed is also left joystick and rotation is right joystick
        
        //adding deadbands
        
        swerveSub.drive(
            (MathUtil.applyDeadband(-joy.getY(), 0.1)), 
            (MathUtil.applyDeadband(-joy.getX(), 0.1)), 
            (MathUtil.applyDeadband(joy.getTwist(), 0.1)),
            true);

        if (joy.getRawButton(5)) {
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
