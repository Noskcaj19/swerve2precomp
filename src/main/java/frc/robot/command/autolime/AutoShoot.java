package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Shooter;

public class AutoShoot extends Command {

    private final Shooter shootSub;

    public AutoShoot(Shooter shootSub) {
        this.shootSub = shootSub;
    }

    @Override
    public void execute() {
        shootSub.setAmpSpeed();
    }

    public boolean isFinished() {
        return false;
    }

}
