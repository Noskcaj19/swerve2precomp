package frc.robot.subsytems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//i dont understand im so tired
//why is it deprecated
//idk
//someone make it stop

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class in extends SubsystemBase{

    //motors that first grab the note under the bumber 
    //kind of like beatle jaws
    private CANSparkMax jaw1 = new CANSparkMax(id, MotorType.kBrushed );
    private CANSparkMax jaw2 = new CANSparkMax(id, MotorType.kBrushed);
    //define more motors
    //however many are in the intake
    //because it is kind of sucking the note under the bumper the two jaws are inverted versions of eachother
    //to suck the note in : the right bumber spins clockwise and the left spins cc
    //to spit it out that is reversed


    // the name suck is so cursed dude omg
    //im so tired
    public void suck(){
        //um uh idk
        //set each motor to go inwards towards center of robot
    }

    public void yuck(){
        //set all the values of suck to negative???? maybe???? idk???
    }
}
