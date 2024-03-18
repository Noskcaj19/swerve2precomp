package frc.robot.command.autolime;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsytems.SwerveSubsystem;

public class NoteRotationAlign2 extends Command{
    private SwerveSubsystem swerveSub;
    private PIDController rotationPid;
    double ku = .111;
    double tu = .6;
    double kuh = .3;
    double tuh = 1.6;
SlewRateLimiter turnLimit = new SlewRateLimiter(.5);


    final LinearFilter horizontalFilter = LinearFilter.movingAverage(3);
    final double getHorizontalOffset() {
        return horizontalFilter.calculate(LimelightHelpers.getTX("limelight-front")/27);
        // return (x.getDouble(160)/160)-1;
        // whatever the distance is
        // returns the specific distance value we want so we can pid it???
        // why is everything so
    }
static int count = 0;
    public NoteRotationAlign2(SwerveSubsystem swerveSub){
        this.swerveSub = swerveSub;
        addRequirements(swerveSub);
        rotationPid = new PIDController(ku*.6, tu*5, tu*.125);
        // horizontalPid = new ProfiledPIDController(kuh*.6, 0, tuh*.125,
        Shuffleboard.getTab("pid_debug").add("note_rotation_PID2"+count, rotationPid);
        count+=1;
    }
    
    @Override
    public void initialize() {
        // forwardPid.reset(1.5);
        // horizontalPid.reset(0);
        rotationPid.reset();
        
    }

    @Override
    public void execute() {
        if (LimelightHelpers.getTV("limelight-front")) {
            var rot = rotationPid.calculate(getHorizontalOffset());
            rot = MathUtil.clamp(rot, -.085, .085);

            swerveSub.drive(0, 0, turnLimit.calculate(rot), false);
        }else {
            swerveSub.drive(0, 0, -0.07, false);
        }
    }

    @Override
    public void end(boolean interrupted) {
        swerveSub.drive(0, 0, 0, false, 0, 0);
    }
    
}
