package frc.robot.subsytems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climbsub extends SubsystemBase{
    private CANSparkMax arm1 = new CANSparkMax(id,  MotorType.kBrushed);
}
