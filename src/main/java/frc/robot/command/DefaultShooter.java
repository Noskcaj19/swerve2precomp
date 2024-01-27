package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Shooter;

public class DefaultShooter extends Command {

    private Joystick joy;
    private Shooter shooterSub;

    public DefaultShooter(Joystick joy, Shooter shooterSub) {
        addRequirements(shooterSub);
        this.shooterSub = shooterSub;
        this.joy = joy;
    }

    public void execute() {

        // align to theeuuuuuhhhhhh amp
        if (joy.getRawButtonPressed(0)) {
            // auto rotation (accpted apriltags ?)
            shooterSub.setAmpSpeed();
        }
        if (joy.getRawButtonReleased(0)) {
            // go back to manual drive
            shooterSub.turnOff();
        }

        // again for speaker
        if (joy.getRawButtonPressed(1)) {
            // auto rotation (accpted apriltags ?)
            shooterSub.setSpeakerSpeed();
        }
        if (joy.getRawButtonReleased(1)) {
            // go back to manual drive
            shooterSub.turnOff();
        }

        // auto-align
        if (joy.getRawButton(2)) {
            // auto align subsysterm
        }
        if (joy.getRawButtonPressed(2)) {
            // BAHAHA return to man drive
        }
    }
}