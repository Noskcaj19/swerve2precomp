package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Mouth;

public class AutoIntake extends Command {

    private final Mouth intakeSub;

    public AutoIntake(Mouth intakeSub) {

        addRequirements(intakeSub);
        this.intakeSub = intakeSub;
    }

    @Override
    public void execute() {
        intakeSub.smartIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSub.stopSmIntake();
    }
}
