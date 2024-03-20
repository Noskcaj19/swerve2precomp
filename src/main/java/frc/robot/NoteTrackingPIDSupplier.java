package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.math.filter.SlewRateLimiter;
import frc.robot.Constants.DriveConstants;

public class NoteTrackingPIDSupplier {
    private PIDController rotationPid =  new PIDController(0.03, 0, 0);
    private MedianFilter horizontalFilter = new MedianFilter(3);
    private SlewRateLimiter turnLimiter = new SlewRateLimiter(1);

    final double getHorizontalOffset() {
        return horizontalFilter.calculate(LimelightHelpers.getTX("limelight-front"));
    }


    public double calculate() {
        if (LimelightHelpers.getTV("limelight-front")) {
            var rot = rotationPid.calculate(getHorizontalOffset());
            rot = MathUtil.clamp(rot, -DriveConstants.MaxVelocityMetersPerSecond/5, DriveConstants.MaxVelocityMetersPerSecond/5);

            return turnLimiter.calculate(rot/DriveConstants.MaxAngularVelocityRadiansPerSecond);
        }
        return 0;
    }
}
