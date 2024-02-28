package frc.robot.command.autolime;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;

public class AutoOffsetLeft extends Command {

    private SwerveSubsystem swerveSub;
    private double goalDistance;
    private double speed;
    private Translation2d startPosition;

    public AutoOffsetLeft(SwerveSubsystem swerveSub, double goalDistance, double speed) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.goalDistance = goalDistance;
        this.speed = speed;

    }

    @Override
    public void initialize() {
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
        if (goalDistance < dist) {
            return true;

        } else {
            return false;
        }
    }
}