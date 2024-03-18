package frc.robot.command.autolime;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.networktables.NetworkTableEvent;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;
import frc.robot.subsytems.SwerveModule;

public class AutoDrive extends Command {

    private SwerveSubsystem swerveSub;
    private double goalDistance;
    private double speed;
    private Translation2d startPosition;
    SlewRateLimiter slew = new SlewRateLimiter(0.2);

    public AutoDrive(SwerveSubsystem swerveSub, double goalDistance, double speed) {

        addRequirements(swerveSub);
        this.swerveSub = swerveSub;
        this.goalDistance = goalDistance;
        this.speed = speed;
        // this.slew = slew;

    }

    @Override
    public void initialize() {
        startPosition = swerveSub.getPose().getTranslation();
        slew.reset(0);
        swerveSub.uh = false;
    }

    @Override
    public void execute() {
        // drive forqard

        NetworkTableInstance.getDefault().getEntry("/Shuffleboard/Tune/Commanded Speed").setDouble(speed);
        var ss=slew.calculate(speed);
        NetworkTableInstance.getDefault().getEntry("/Shuffleboard/Tune/Limited Speed").setDouble(ss);
        swerveSub.drive(ss, 0, 0, false);
        // hird

    }

    @Override
    public void end(boolean interrupted) {
        swerveSub.drive(0, 0, 0, false, 0, 0);
    }

    @Override
    public boolean isFinished() {

        double dist = swerveSub.getPose().getTranslation().getDistance(startPosition);
        if (goalDistance < dist) {
            return true;

        } else {
            return false;
        }
        // i finally get it now
        // goal distance is how far we want the robot to go
        // dist is how far we currently are away from the starting pos
        // if how far away we currently are is greater than how far away we want to be
        // the auto is finished
        // :DDDD
    }
}
