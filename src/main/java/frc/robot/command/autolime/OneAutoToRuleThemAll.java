package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class OneAutoToRuleThemAll extends SequentialCommandGroup {

    SwerveSubsystem swerveSub;
    Shooter shooterSub;
    Mouth intakeSub;

    public OneAutoToRuleThemAll(SwerveSubsystem swerveSub, Shooter shooterSub, Mouth intakeSub) {
        addRequirements(swerveSub);
        addRequirements(shooterSub);
        this.swerveSub = swerveSub;
        this.shooterSub = shooterSub;
        this.intakeSub = intakeSub;
        addCommands(
                new AutoShoot(shooterSub, intakeSub).until(intakeSub::hasNoteLeft)/* .withTimeout(2) */, // does it have
                                                                                                         // to get up to
                                                                                                         // speed?
                new AutoDrive(swerveSub, 5, 0.2).withTimeout(2));
    }

}