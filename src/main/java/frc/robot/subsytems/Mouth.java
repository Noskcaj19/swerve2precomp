package frc.robot.subsytems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import au.grapplerobotics.LaserCan;

//i dont understand im so tired
//why is it deprecated
//idk
//someone make it stop

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Mouth extends SubsystemBase {

    // private CANSparkMax intakeOne = new CANSparkMax(0, MotorType.kBrushed);
    // private CANSparkMax intakeTwo = new CANSparkMax(0, MotorType.kBrushed);
    // private CANSparkMax transport = new CANSparkMax(0, MotorType.kBrushed);

    VictorSPX intakeOne = new VictorSPX(8);
    VictorSPX intakeTwo = new VictorSPX(9);
    TalonSRX transport = new TalonSRX(12);

    // laser
    private LaserCan laser = new LaserCan(44);

    // boolena
    private boolean isTaking = false;

    // motors that first grab the note under the bumber
    // kind of like beatle jaws
    public Mouth() {
        intakeTwo.setInverted(true);
    }

    public void setTaking(boolean isTaking) {
        this.isTaking = isTaking;
    }
    // define more motors
    // however many are in the intake
    // because it is kind of sucking the note under the bumper the two jaws are
    // inverted versions of eachother
    // to suck the note in : the right bumber spins clockwise and the left spins cc
    // to spit it out that is reversed

    // im so tired
    // eat takes in the note
    // it intakes it

    public void eat(boolean on) {
        // um uh idk
        // set each motor to go inwards towards center of robot

        intakeOne.set(ControlMode.PercentOutput, 0.5);
        intakeTwo.set(ControlMode.PercentOutput, -0.5);
        transport.set(ControlMode.PercentOutput, 0.5);
    }

    public void sing() {
        // set all the values of suck to negative???? maybe???? idk???
        intakeOne.set(ControlMode.PercentOutput, -0.5);
        intakeTwo.set(ControlMode.PercentOutput, 0.5);
        transport.set(ControlMode.PercentOutput, -0.5);
    }

    public void intakeOff() {
        intakeOne.set(ControlMode.PercentOutput, 0);
        intakeTwo.set(ControlMode.PercentOutput, 0);
        transport.set(ControlMode.PercentOutput, 0);
    }

    public void printshtuff() {
        LaserCan.Measurement m = laser.getMeasurement();
        System.out
                .println("mm:" + m.distance_mm + " valid " + (m.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT));
    }

    @Override
    public void periodic() {
        if (isTaking) {
            LaserCan.Measurement measurement = laser.getMeasurement();

            if (measurement != null && measurement.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT) {
                if (measurement.distance_mm < 235) {

                    intakeOne.set(ControlMode.PercentOutput, .6);
                    intakeTwo.set(ControlMode.PercentOutput, .7);
                    transport.set(ControlMode.PercentOutput, 0.1);
                }
                if (measurement.distance_mm < 300) {

                    intakeOne.set(ControlMode.PercentOutput, .6);
                    intakeTwo.set(ControlMode.PercentOutput, .7);
                    transport.set(ControlMode.PercentOutput, 0.1);
                }
                if (measurement.distance_mm > 490) {

                    intakeOne.set(ControlMode.PercentOutput, .6);
                    intakeTwo.set(ControlMode.PercentOutput, .7);
                    transport.set(ControlMode.PercentOutput, 0.1);
                }

            } else {
                intakeOne.set(ControlMode.PercentOutput, .5);
                intakeTwo.set(ControlMode.PercentOutput, 0.5);
                transport.set(ControlMode.PercentOutput, .5);
            }
        }
    }
}