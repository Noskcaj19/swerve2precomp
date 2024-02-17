package frc.robot.subsytems;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    // motor
    private final CANSparkMax shooterOne = new CANSparkMax(0, MotorType.kBrushed);

    private final CANSparkMax shooterTwo = new CANSparkMax(0, MotorType.kBrushed);

    // moter
    public void setAmpSpeed() {
        shooterOne.set(.5);
        shooterTwo.set(.5);
        // whatever
    }

    public void setSpeakerSpeed() {
        // etc
        shooterOne.set(.8);
        shooterTwo.set(.8);
    }

    public void turnOff() {

    }
}
