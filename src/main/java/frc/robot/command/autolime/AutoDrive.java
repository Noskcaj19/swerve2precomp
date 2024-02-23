package frc.robot.command.autolime;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;
import frc.robot.subsytems.SwerveModule;

public class AutoDrive extends Command {

    private SwerveSubsystem swerveSub;
    private double goalDistance;
    private double speed;
    private Translation2d startPosition;

    public AutoDrive(SwerveSubsystem swerveSub, double goalDistance, double speed) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.goalDistance = goalDistance;
        this.speed = speed;

    }

    @Override
    public void initialize() {
        swerveSub.zeroYaw();
        startPosition = swerveSub.getPose().getTranslation();
    }

    @Override
    public void execute() {
        // drive forqard
        swerveSub.drive(speed, 0, 0, false, 0, 0);
        // hird

    }

    @Override
    public void end(boolean interrupted) {
        swerveSub.drive(0, 0, 0, false, 0, 0);
    }

    @Override
    public boolean isFinished() {

        // TODO tweak for going backwards?

        double dist = swerveSub.getPose().getTranslation().getDistance(startPosition);
        if (goalDistance > 0 && goalDistance < dist) {
            return true;

        } else {
            return false;
        }
//i finally get it now
//goal distance is how far we want the robot to go
//dist is how far we currently are away from the starting pos
//if how far away we currently are is greater than how far away we want to be the auto is finished
//:DDDD
    }
}
