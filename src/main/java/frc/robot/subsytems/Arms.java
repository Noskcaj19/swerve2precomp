package frc.robot.subsytems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arms extends SubsystemBase {

    private TalonSRX arm1 = new TalonSRX(0);
    private TalonSRX arm2 = new TalonSRX(0);

    private final PIDController extentionPID = new PIDController(0, 0, 0);

    // private
    public Arms() {
    }

    public void setArmLimitSetpoint(double setpoint) {
        extentionPID.setSetpoint(MathUtil.clamp(setpoint, 0, 0));
    }

    public void upDown(boolean choice) {
        if (choice) {
            arm1.set(TalonSRXControlMode.PercentOutput, .5);
            arm2.set(TalonSRXControlMode.PercentOutput, .5);
        } else {
            arm1.set(TalonSRXControlMode.PercentOutput, -.5);
            arm2.set(TalonSRXControlMode.PercentOutput, -.5);
        }
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
