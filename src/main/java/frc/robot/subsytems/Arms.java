package frc.robot.subsytems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arms extends SubsystemBase {

    TalonSRX arm1 = new TalonSRX(27);
    TalonSRX arm2 = new TalonSRX(3);

    private final PIDController extentionPID = new PIDController(0, 0, 0);

    // private
    public Arms() {
        // arm2.follow(arm1);
    }

    public void setArmLimitSetpoint(double setpoint) {
        extentionPID.setSetpoint(MathUtil.clamp(setpoint, 0, 0));
    }

    // public void upDown(boolean choice) {
    // if (choice) {
    // arm1.set(TalonSRXControlMode.PercentOutput, .5);
    // } else {
    // arm1.set(TalonSRXControlMode.PercentOutput, -.5);
    // }
    // }

    public void armsUp() {
        arm1.set(TalonSRXControlMode.PercentOutput, 0.8);
        arm2.set(TalonSRXControlMode.PercentOutput, 0.8);
    }

    public void armsDown() {
        arm1.set(TalonSRXControlMode.PercentOutput, -0.99);
        arm2.set(TalonSRXControlMode.PercentOutput, -0.99);
    }

    public void turnOff() {
        arm1.set(TalonSRXControlMode.PercentOutput, 0);
        arm2.set(TalonSRXControlMode.PercentOutput, 0);
    }

    public void overrideLeft(double percent) {
        arm1.set(ControlMode.PercentOutput, percent);
    }
    public void overrideRight(double percent) {
        arm2.set(ControlMode.PercentOutput, percent);
    }
    public double getLeftCurrent() {
        return arm1.getStatorCurrent();
    }
    public double getRightCurrent() {
        return arm2.getStatorCurrent();
    }

    @Override
    public void periodic() {

    }
    // public void down(boolean choice) {
    // if (choice) {
    // arm1.set(-.5);
    // arm2.set(-.5);
    // }
    // }

}
