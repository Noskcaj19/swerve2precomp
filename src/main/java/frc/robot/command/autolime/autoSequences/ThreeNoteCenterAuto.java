package frc.robot.command.autolime.autoSequences;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.LimelightHelpers;
import frc.robot.command.autolime.AutoAlignNotes;
import frc.robot.command.autolime.AutoAlignTags;
import frc.robot.command.autolime.AutoDrive;
import frc.robot.command.autolime.AutoIntake;
import frc.robot.command.autolime.AutoRotate;
import frc.robot.command.autolime.AutoShootSmart;
import frc.robot.command.autolime.NoteRotationAlign;
import frc.robot.command.autolime.NoteRotationAlign2;
import frc.robot.subsytems.Intake;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class ThreeNoteCenterAuto extends SequentialCommandGroup{

    SwerveSubsystem swerveSub;
    Shooter shooterSub;
    Intake intakeSub;

    public ThreeNoteCenterAuto(SwerveSubsystem swerveSub, Shooter shooterSub, Intake intakeSub) {
        addRequirements(swerveSub);
        addRequirements(shooterSub);
        addRequirements(intakeSub);
        this.swerveSub = swerveSub;
        this.shooterSub = shooterSub;
        this.intakeSub = intakeSub;

        var autoAlign = new AutoAlignTags(swerveSub);
        var autoAlignNote3 = new AutoAlignTags(swerveSub);

        addCommands(
                new AutoAlignTags(swerveSub).withTimeout(.5),
                new StopCommand(swerveSub),
                new AutoShootSmart(shooterSub, intakeSub),
                Commands.race(
                    new AutoDrive(swerveSub, 3, 0.2),
                    Commands.race(
                        new AutoIntake(intakeSub),
                        new WaitUntilCommand(intakeSub::hasNote).andThen(new WaitCommand(.15))
                    )
                ),
                new AutoDrive(swerveSub, 1, -0.2).until(this::closeEnough).withTimeout(4),
                autoAlign.until(autoAlign::aligned),//.until(AutoAlignTags::aligned),
                // this line is not a mistake, we might have overshot in the above line, so we run a bit longer
                new AutoAlignTags(swerveSub).withTimeout(.5), 
                new StopCommand(swerveSub),
                new AutoShootSmart(shooterSub, intakeSub).withTimeout(4),
                // end 2nd note
                new AutoRotate(swerveSub, -25, 0.1),
                new NoteRotationAlign(swerveSub).withTimeout(1),
                Commands.race(
                    new AutoDrive(swerveSub, 2.5, 0.2),
                    Commands.race(
                        new AutoIntake(intakeSub),
                        new WaitUntilCommand(intakeSub::hasNote).andThen(new WaitCommand(.15))
                    )
                ),
                new AutoRotate(swerveSub, 15, 0.025).until(AutoAlignTags::speakerAimReady).withTimeout(5),
                autoAlignNote3.until(autoAlignNote3::aligned),//.until(AutoAlignTags::aligned),
                // this line is not a mistake, we might have overshot in the above line, so we run a bit longer
                new AutoAlignTags(swerveSub).withTimeout(1), 
                new StopCommand(swerveSub),
                new AutoShootSmart(shooterSub, intakeSub)
             );

                // new AutoRotate(swerveSub, 90, 0.5),
                //  Commands.race(
                //     new AutoDrive(swerveSub, 3, 0.2),
                //     Commands.race(
                //         new AutoIntake(intakeSub),
                //         new WaitUntilCommand(intakeSub::hasNote).andThen(new WaitCommand(.3))
                //     )
                // ),
                // new Auto
    }

    
    private MedianFilter zFilter = new MedianFilter(7);
    private boolean closeEnough() {
        if(LimelightHelpers.getTV("limelight-back")){
        var rawZ = LimelightHelpers.getTargetPose3d_CameraSpace(("limelight-back")).getZ();
        var z = zFilter.calculate(rawZ);
        if(z < 1.3){
            return true;
        }
        else{
            return false;
        }
        }
        else{
            return false;
        }

    }
}
