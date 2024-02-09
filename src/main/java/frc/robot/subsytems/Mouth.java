package frc.robot.subsytems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

//i dont understand im so tired
//why is it deprecated
//idk
//someone make it stop

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Mouth extends SubsystemBase{

    private  CANSparkMax intake = new CANSparkMax(0, MotorType.kBrushed );
    private  CANSparkMax transport = new CANSparkMax(0, MotorType.kBrushed);
    //motors that first grab the note under the bumber 
    //kind of like beatle jaws
    public Mouth(){}

    //define more motors
    //however many are in the intake
    //because it is kind of sucking the note under the bumper the two jaws are inverted versions of eachother
    //to suck the note in : the right bumber spins clockwise and the left spins cc
    //to spit it out that is reversed


    // the name suck is so cursed dude omg
    //im so tired
    public  void eat(boolean on){
        //um uh idk
        //set each motor to go inwards towards center of robot

        intake.set(0.5);
    }

    public  void sing(boolean on){
        //set all the values of suck to negative???? maybe???? idk???
        intake.set(-0.5);
    }
}

