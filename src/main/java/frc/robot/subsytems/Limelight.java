package frc.robot.subsytems;

import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.LimelightHelpers;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Limelight {
    
    public NetworkTable getTable() {
        return NetworkTableInstance.getDefault().getTable("limelight");
    }

    private double targetValue;

    public boolean isTargetDetected() { // keeps track of whether target is detected
        return (targetValue > 0.0);
    }

    public double getX() {
        return LimelightHelpers.getTX("");
    }

    public double getY() {
        return LimelightHelpers.getTY("");
    }

    public void limelightLightOff() {
        LimelightHelpers.setLimelightNTDouble("", "", 1);
    }

    public void limelightLightOn() {
        LimelightHelpers.setLimelightNTDouble("", "", 0);
    }
}
