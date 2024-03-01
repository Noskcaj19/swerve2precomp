package frc.robot.subsytems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import au.grapplerobotics.LaserCan;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    VictorSPX intakeOne = new VictorSPX(8);
    VictorSPX intakeTwo = new VictorSPX(9);
    TalonSRX transport = new TalonSRX(12);
    // private PIDController intakeP 

    // laser
    private LaserCan laser = new LaserCan(44);

    // motors that first grab the note under the bumber
    // kind of like beatle jaws
    public Intake() {
        for (var ste : Thread.currentThread().getStackTrace()) {
            System.out.println(ste);
        }

        intakeTwo.setInverted(true);
    }

    // boolena
    private boolean isTaking = false;

    public boolean get() {
        return isTaking;
    }

    public void smartIntake() {
        isTaking = true;
    }

    public void stopSmIntake() {
        isTaking = false;
    }

    private boolean isFeeding = false;

    public boolean getFeeding() {
        return isFeeding;
    }

    public void feedOn() {
        isFeeding = true;
    }

    public void feedOff() {
        isFeeding = false;
    }

    public void eat() {

        intakeOne.set(ControlMode.PercentOutput, 0.2);
        intakeTwo.set(ControlMode.PercentOutput, 0.2);
        transport.set(ControlMode.PercentOutput, 0.2);
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

    public void feedToShooter() {
        intakeOne.set(ControlMode.PercentOutput, 0.2);
    }

    public void feedBackwards() {
        transport.set(ControlMode.PercentOutput, -0.2);
    }

    public void printshtuff() {
        LaserCan.Measurement m = laser.getMeasurement();
        System.out
                .println("mm:" + m.distance_mm + " valid " + (m.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT));
    }

    public boolean hasNoteLeft() {

        LaserCan.Measurement m = laser.getMeasurement();
        if (m == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void periodic() {
        // intakeTwo.set(ControlMode.PercentOutput, .1);

        if (isTaking) {
            LaserCan.Measurement measurement = laser.getMeasurement();
            if (measurement != null)
                System.out.println("measurement:" + measurement.status + " valid "
                        + (measurement.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT));
            if (measurement != null && measurement.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT) {
                if (measurement.distance_mm < 295) {
                    System.out.println("1");
                    intakeOne.set(ControlMode.PercentOutput, .0);
                    intakeTwo.set(ControlMode.PercentOutput, .0);
                    transport.set(ControlMode.PercentOutput, 0.0);
                    return;
                } else if (measurement.distance_mm < 370) {
                    System.out.println("2");

                    intakeOne.set(ControlMode.PercentOutput, .3);
                    intakeTwo.set(ControlMode.PercentOutput, .45);
                    transport.set(ControlMode.PercentOutput, 0.1);
                    return;
                }
                System.out.println("3");
                intakeOne.set(ControlMode.PercentOutput, .5);
                intakeTwo.set(ControlMode.PercentOutput, 0.5);
                transport.set(ControlMode.PercentOutput, .7);
                return;
                // else if (measurement.distance_mm < 300) {

                // intakeOne.set(ControlMode.PercentOutput, .3);
                // intakeTwo.set(ControlMode.PercentOutput, .4);
                // transport.set(ControlMode.PercentOutput, 0.1);
                // }
                // if (measurement.distance_mm > 490) {

                // intakeOne.set(ControlMode.PercentOutput, .6);
                // intakeTwo.set(ControlMode.PercentOutput, .7);
                // transport.set(ControlMode.PercentOutput, 0.1);
                // }

            } else {

                System.out.println("4");
                intakeOne.set(ControlMode.PercentOutput, .5);
                intakeTwo.set(ControlMode.PercentOutput, 0.5);
                transport.set(ControlMode.PercentOutput, .7);

            }
        } else if (isFeeding) {
            transport.set(ControlMode.PercentOutput, .7);
            intakeTwo.set(ControlMode.PercentOutput, 0.5);
        } else {
            intakeOne.set(ControlMode.PercentOutput, 0);
            intakeTwo.set(ControlMode.PercentOutput, 0);
            transport.set(ControlMode.PercentOutput, 0);
        }
    }
}