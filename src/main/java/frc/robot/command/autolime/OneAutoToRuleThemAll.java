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
    }

    public void firstAuto() {
        addCommands(
                new AutoShoot(shooterSub, intakeSub).withTimeout(3), // does it have to get up to speed?
                new AutoDrive(swerveSub, 0.1, 0.1).withTimeout(1));
    }

}