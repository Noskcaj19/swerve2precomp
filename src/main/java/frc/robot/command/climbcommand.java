package frc.robot.command;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends Command{

    private Joystick joy;
    private Climb climbSub = new Climb();
    boolean status = false;

public Climb (Joystick inJoy, Climb climb){
    this.climbSub = climbsub;
    this.joy = inJoysti

 
    @Override
    public void execute() {
        if status = !status;
            climbSub.upDown(status);
        }
        else if(joy.getRawButton(11)){
            climbSub.upDown(status);
        }


}

}
