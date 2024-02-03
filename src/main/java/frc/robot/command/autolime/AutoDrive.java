package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.SwerveSubsystem;
import frc.robot.subsytems.SwerveModule;

public class AutoDrive extends Command {

    private SwerveSubsystem swerveSub;
    private SwerveModule swerveMod;
    private double distance;
    private double speed;
    private double position;
    private boolean done;

    public AutoDrive(SwerveSubsystem swerveSub) {
        addRequirements(swerveSub);

        this.swerveSub = swerveSub;
        this.distance = distance;
        this.speed = speed;
        this.position = position;

    }

    @Override
    public void initialize() {
        swerveSub.zeroYaw();
    }

    final double setDistance(double distance) {
        return distance;
    }

    final double setPosition(double position) {
        return position;
    }
}
/*
 * @Override
 * public void execute(){
 * if (distance > 0) {
 * if (swerveMod.getPosition(). > position ) {
 * swerveSub.drive(speed, 0, 0, isFinished());
 * }
 * else {
 * swerveSub.drive(0,0,0,isFinished());
 * done = true;
 * }
 * 
 * }
 * }
 * 
 * }
 */
