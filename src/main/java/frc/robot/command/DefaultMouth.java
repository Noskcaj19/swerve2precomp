package frc.robot.command;

import frc.robot.subsytems.Mouth;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

public class DefaultMouth extends Command {

    private final XboxController secondaryController;
    Mouth mouth;

    public DefaultMouth(Mouth mouth, XboxController secondaryController) {

        addRequirements(mouth);
        this.secondaryController = secondaryController;
        this.mouth = mouth;
    }

    // comment out which control method the drivers dont want
    // private final XboxController primaryController = new XboxController(0);
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        if (true) {
            // mouth.printshtuff();
        }

        if (secondaryController.getLeftBumper()) {
            mouth.smartIntake();
        } else {
            mouth.stopSmIntake();
        }
        // if (primaryJoystick.getRawButtonPressed(12)) {
        // mouth.smartIntake();
        // // System.out.println(mouth.get());
        // } else if (primaryJoystick.getRawButtonReleased(12)) {
        // mouth.stopSmIntake();
        // // System.out.println(mouth.get());
        // }

        // System.out.println(mouth.getTaking());

        if (secondaryController.getRightBumperPressed()) {
            mouth.feedOn();
        }
        if (secondaryController.getRightBumperReleased()) {
            mouth.feedOff();
        }
        // if (primaryJoystick.getRawButton(4)) {
        // mouth.sing();
        // }
        // if (primaryJoystick.getRawButtonReleased(4)) {
        // mouth.intakeOff();
        // }
    }
}
