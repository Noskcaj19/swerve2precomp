package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class AutoShoot extends Command {

    private Shooter shootSub;
    private Mouth intakeSub;

    public AutoShoot(Shooter shootSub, Mouth intakeSub) {

        addRequirements(shootSub);
        addRequirements(intakeSub);
        this.shootSub = shootSub;
        this.intakeSub = intakeSub;
    }

    @Override
    public void execute() {
        shootSub.shootSpeaker();
        if (shootSub.isToSpeakerSpeed()) {
            intakeSub.feedOn();
        } else {
            intakeSub.feedOff();
        }
    }

    // @Override
    // public void end(){
    // intakeSub.feedOff();
    // }
}
