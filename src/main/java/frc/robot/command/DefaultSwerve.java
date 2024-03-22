package frc.robot.command;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.NoteTrackingPIDSupplier;
import frc.robot.subsytems.*;

public class DefaultSwerve extends Command {

    private Joystick joy;
    private SwerveSubsystem swerveSub;
    private NoteTrackingPIDSupplier noteAlignmentSupplier = new NoteTrackingPIDSupplier();
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
        // xspeed is xbox controller left joystick yspeed is also left joystick and
        // rotation is right joystick

        // adding deadbands

        var xSpeed = (MathUtil.applyDeadband(-joy.getY(), 0.1));
        var ySpeed = (MathUtil.applyDeadband(-joy.getX(), 0.1));
        var rot = (MathUtil.applyDeadband(-joy.getTwist(), 0.1));

        if (!joy.getTrigger()) {
            xSpeed *= 0.5;
            ySpeed *= 0.5;
            rot *= 0.1;
        } else {
            rot *= 0.5;
        }

        if (joy.getRawButton(7)) {
            xSpeed *= 0.75;
            ySpeed *= 0.75;
            rot *= 0.2;
        }

        if (joy.getRawButton(12)) {
            SwerveSubsystem.zeroYaw();
        }

        if (joy.getRawButton(4)) {
            rot += noteAlignmentSupplier.calculate();
        }

        swerveSub.drive(xSpeed, ySpeed, rot, !joy.getRawButton(2));

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
