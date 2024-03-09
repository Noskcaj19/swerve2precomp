package frc.robot.command.autolime.autoSequences;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.command.autolime.AutoDrive;
import frc.robot.command.autolime.AutoIntake;
import frc.robot.command.autolime.AutoShoot;
import frc.robot.command.autolime.AutoShootSmart;
import frc.robot.subsytems.Intake;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class CenterAuto extends SequentialCommandGroup {

    SwerveSubsystem swerveSub;
    Shooter shooterSub;
    Intake intakeSub;

    public CenterAuto(SwerveSubsystem swerveSub, Shooter shooterSub, Intake intakeSub) {
        addRequirements(swerveSub);
        addRequirements(shooterSub);
        this.swerveSub = swerveSub;
        this.shooterSub = shooterSub;
        this.intakeSub = intakeSub;

        addCommands(
                // new AutoShoot(shooterSub, intakeSub).until(intakeSub::doesntHaveNote).withTimeout(2), 
                new AutoShootSmart(shooterSub, intakeSub),
                new AutoDrive(swerveSub, 5, 0.2).withTimeout(0.01),
                Commands.race(new AutoDrive(swerveSub, 3, 0.2), new AutoIntake(intakeSub)).until(intakeSub::hasNote),
                new AutoDrive(swerveSub, 5, -0.2).until(swerveSub::hasHitSomething),
                new AutoShootSmart(shooterSub, intakeSub));
    }
}