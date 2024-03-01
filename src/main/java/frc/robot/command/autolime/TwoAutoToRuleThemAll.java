
package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class TwoAutoToRuleThemAll extends SequentialCommandGroup {

    SwerveSubsystem swerveSub;
    Shooter shooterSub;
    Mouth intakeSub;

    public TwoAutoToRuleThemAll(SwerveSubsystem swerveSub, Shooter shooterSub, Mouth intakeSub) {
        addRequirements(swerveSub);
        addRequirements(shooterSub);
        this.swerveSub = swerveSub;
        this.shooterSub = shooterSub;
        this.intakeSub = intakeSub;
        addCommands(
                new AutoRotate(swerveSub, -10, 0.1).withTimeout(3),
                new AutoDrive(swerveSub, 5, 0.2).withTimeout(2));
    }

}
