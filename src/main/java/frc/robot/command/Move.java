package frc.robot.command;

import frc.robot.subsytems.Mouth;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

public class Move extends Command {

    private final Joystick primaryJoystick;
    Mouth mouth = new Mouth();
    private boolean status = false;

    public Move(Mouth mouth, Joystick firstJoy) {

        addRequirements(mouth);
        this.primaryJoystick = firstJoy;
        this.mouth = mouth;
    }

    // comment out which control method the drivers dont want
    // private final XboxController primaryController = new XboxController(0);
    @Override
    public void execute() {
        // TODO Auto-generated method stub

        if (primaryJoystick.getRawButtonPressed(6)) {
            status = !status;
            mouth.eat(status);
        }
        if (primaryJoystick.getRawButtonReleased(6)){
            mouth.intakeOff();
        }
        if (primaryJoystick.getRawButton(4)) {
            status = !status;
            mouth.sing(status);
        }
        if(primaryJoystick.getRawButtonReleased(4)){
            mouth.intakeOff();
        }
        }
    }


