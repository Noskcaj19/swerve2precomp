package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class AutoShoot extends Command {

    private Shooter shootSub;

    public AutoShoot(Shooter shootSub) {

        addRequirements(shootSub);
        this.shootSub = shootSub;
    }

    @Override
    public void execute() {
        shootSub.shootSpeaker();
    }
}
