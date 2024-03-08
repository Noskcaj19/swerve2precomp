package frc.robot.command.autolime.autoSequences;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.command.autolime.AutoDrive;
import frc.robot.command.autolime.AutoIntakeDrive;
import frc.robot.command.autolime.AutoRotate;
import frc.robot.command.autolime.AutoShoot;
import frc.robot.subsytems.Intake;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class RightAuto extends SequentialCommandGroup{

    SwerveSubsystem swerveSub;
    Shooter ShooterSub;
    Intake intakeSub;

    public RightAuto (SwerveSubsystem swerveSub, Shooter shooterSub, Intake intakeSub){
        addCommands(
        new AutoShoot(shooterSub, intakeSub).withTimeout(3),
        new AutoDrive(swerveSub, 0.3, 0.2).withTimeout(3),
        new AutoRotate(swerveSub, -25, 0.1).withTimeout(3),
        new AutoIntakeDrive(swerveSub, intakeSub, 5, 0.3).withTimeout(2)
        );
    }
    
}
