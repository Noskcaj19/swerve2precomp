package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;

public class DefaultShooter extends Command {

    private XboxController secondaryController;
    private Shooter shooterSub;
    private Mouth intakeSub;

    public DefaultShooter(XboxController secondController, Shooter shooterSub, Mouth intakeSub) {
        addRequirements(shooterSub);
        this.shooterSub = shooterSub;
        this.secondaryController = secondController;
        this.intakeSub = intakeSub;
    }

    public void execute() {

        // align to theeuuuuuhhhhhh amp
        if (secondaryController.getAButtonPressed()) {
            // auto rotation (accpted apriltags ?)
            shooterSub.shootAmp();

            if (shooterSub.isToAmpSpeed()) {
                intakeSub.feedToShooter();
            }
        }
        if (secondaryController.getAButtonReleased()) {
            // go back to manual drive
            shooterSub.turnOff();
        }

        // again for speaker
        if (secondaryController.getYButtonPressed()) {
            // auto rotation (accpted apriltags ?)
            shooterSub.shootSpeaker();

            if (shooterSub.isToSpeakerSpeed()) {
                intakeSub.feedToShooter();
            }
        }
        if (secondaryController.getYButtonReleased()) {
            // go back to manual drive
            shooterSub.turnOff();
        }

        // // auto-align
        // if (joy.getRawButton(2)) {
        // // auto align subsysterm
        // }
        // if (joy.getRawButtonPressed(2)) {
        // // BAHAHA return to man drive
        // }
    }
}