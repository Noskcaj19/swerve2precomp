package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;

public class OneAutoToRuleThemAll extends SequentialCommandGroup{

    SwerveSubsystem swerveSub;
    Shooter shooterSub;

    public OneAutoToRuleThemAll(SwerveSubsystem swerveSub, Shooter shooterSub){
        addRequirements(swerveSub);
        addRequirements(shooterSub);
        this.swerveSub = swerveSub;
        this.shooterSub = shooterSub;
    }

    public void centralAuto(){

    }

    public void ampAuto(){

    }

    public void otherAutoRenameLater(){

    }
}