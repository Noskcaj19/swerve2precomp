package frc.robot.command;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Arms;

public class HomeClimb extends Command {
    private MedianFilter filterLeft = new MedianFilter(3);
    private MedianFilter filterRight = new MedianFilter(3);
    private Arms climbSubsystem;

    public HomeClimb(Arms climbSubsystem) {
        addRequirements(climbSubsystem);
        this.climbSubsystem = climbSubsystem;
    }

    @Override
    public void initialize() {
        leftDone = false;
        rightDone = false;
        filterLeft.reset();
        filterRight.reset();
        climbSubsystem.overrideLeft(.65);
        climbSubsystem.overrideRight(.65);
    }

    boolean leftDone = false;
    boolean rightDone = false;

    @Override
    public void execute() {
         if (!leftDone) {
            var left = filterLeft.calculate(climbSubsystem.getLeftCurrent());
            if (Math.abs(left) > 10) {
                climbSubsystem.overrideLeft(0);
                leftDone = true;
            }
         }
         if (!rightDone) {
            var right = filterRight.calculate(climbSubsystem.getRightCurrent());
            if (Math.abs(right) > 10) {
                climbSubsystem.overrideRight(0);
                rightDone = true;
            }
         }
    }

    @Override
    public void end(boolean interrupted) {
        climbSubsystem.overrideLeft(0);
        climbSubsystem.overrideRight(0);
    }

    @Override
    public boolean isFinished() {
        return leftDone && rightDone;
    }
}