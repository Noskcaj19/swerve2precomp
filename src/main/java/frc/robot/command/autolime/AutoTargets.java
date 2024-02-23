package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;

public class AutoTargets extends Command {

    private int choice;
    public AutoTargets (int choice){
        this.choice = choice;
    }

//so theoretically with this we can use it to define a point on the field we want to go to, speaker or the amp so we can use this in auto??

    @Override
    public void initialize(){

        if(choice == 1){

        }
        else if(choice == 2){
            
        }
    }

    @Override
    public void execute(){

    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
    

