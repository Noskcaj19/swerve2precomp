package frc.robot.command;

import frc.robot.subsytems.Mouth;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

public class DefaultMouth extends Command {

    private final Joystick primaryJoystick;
    Mouth mouth = new Mouth();

    public DefaultMouth(Mouth mouth, Joystick firstJoy) {

        addRequirements(mouth);
        this.primaryJoystick = firstJoy;
        this.mouth = mouth;
    }

    // comment out which control method the drivers dont want
    // private final XboxController primaryController = new XboxController(0);
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        if (true) {
            mouth.printshtuff();
        }

        if (primaryJoystick.getRawButton(12)) {
            mouth.setTaking(true);
        } else {
            mouth.setTaking(false);
        }

        if (primaryJoystick.getRawButtonPressed(6)) {
            mouth.eat(true);
        }
        if (primaryJoystick.getRawButtonReleased(6)) {
            mouth.intakeOff();
        }
        if (primaryJoystick.getRawButton(4)) {
            mouth.sing();
        }
        if (primaryJoystick.getRawButtonReleased(4)) {
            mouth.intakeOff();
        }
    }
}
