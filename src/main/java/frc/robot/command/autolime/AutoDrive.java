package frc.robot.command.autolime;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;
import frc.robot.subsytems.SwerveModule;

public class AutoDrive extends Command {

    private SwerveSubsystem swerveSub;
    private double distance;
    private double speed;
    private Translation2d startPosition;

    public AutoDrive(SwerveSubsystem swerveSub) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;

    }

    @Override
    public void initialize() {
        swerveSub.zeroYaw();
        startPosition = swerveSub.getPose().getTranslation();
    }

    @Override
    public void execute() {
        // drive forqard

    }

    @Override
    public boolean isFinished() {

        // TODO tweak for going backwards?

        double dist = swerveSub.getPose().getTranslation().getDistance(startPosition);
        if (distance > 0 && distance < dist) {
            return true;

        } else {
            return false;
        }

    }
}
