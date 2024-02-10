package frc.robot.command.autolime;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;
import frc.robot.subsytems.SwerveModule;

public class AutoDrive extends Command {

    private SwerveSubsystem swerveSub;
    private SwerveModule swerveMod;
    private double distance;
    private double speed;
    private Translation2d startPosition;
    private boolean done;

    public AutoDrive(SwerveSubsystem swerveSub) {
        addRequirements(swerveSub);

        this.swerveSub = swerveSub;
        this.distance = distance;
        this.speed = speed;
        this.startPosition = startPosition;

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
