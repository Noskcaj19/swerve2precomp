package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsytems.Arms;

public class DefaultClimb extends Command {

    private Joystick joy;
    private Arms climbSub = new Arms();
    boolean status = false;

    public DefaultClimb(Joystick inJoy, Arms climb) {
        this.climbSub = climb;
        this.joy = inJoy;
    }

    @Override
    public void execute() {

        // double extendController;
        // if (secondaryController.getRightY() < 0.03 && secondaryController.getRightY()
        // > -0.03) {
        // extendController = 0;
        // } else {
        // extendController = secondaryController.getRightY() * 2;
        // }

        // var extendSet = -extendController + -clawSystem.getExtendSetPoint();
        // climbSub.set(extendSet);

        if (joy.getRawButton(10)) {
            status = !status;
            climbSub.upDown(status);
        } else if (joy.getRawButton(11)) {
            climbSub.upDown(status);
        }

    }

}