package frc.robot.command.autolime;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsytems.SwerveSubsystem;

public class AutoTargets extends Command {

    private int choice;
    private SwerveSubsystem swerveSub;
    private Translation2d startPos;
    private Translation2d goalPos;
    private double speed;
    private double xOffset;
    private double yOffset;
    private ProfiledPIDController xPID;
    private ProfiledPIDController yPID;
    public AutoTargets (int choice, SwerveSubsystem swerveSub, double speed){
        this.choice = choice;
        this.swerveSub = swerveSub;
        this.speed = speed;
    }

//get goal as translation2d
//two translation2ds, one for where we are, and one for where we want to be (startPos and goalPos)
//goal for amp and goal for speaker
//xoffset is difference between goalPos.x() and startPos.x()
//yoffset is difference between goalPos.y() and startPos.y()
//figure out the translation2d values of amp and speaker
//or look around until the limelight finds the id we are looking for then set that tag as the translation
    public double getXOffset(){
        xOffset = startPos.getDistance(goalPos);
        return xOffset;
    }

    public double getYOffset(){
        yOffset = startPos.getDistance(goalPos);
        return yOffset;
    }

    @Override
    public void initialize(){

        swerveSub.zeroYaw();
        startPos = swerveSub.getPose().getTranslation();

        xPID = new ProfiledPIDController(1.1, 0, 0,
            new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond / 3, 2));
        yPID = new ProfiledPIDController(xOffset, speed, choice, null);

        //how to 
        // if(choice == 1){

        // }
        // else if(choice == 2){
            
        // }
    }

    @Override
    public void execute(){
        // swerveSub.drive(speed, speed, choice, isScheduled());
        //pid controllers calculate their respective values then we put them in the drive function
        //not sure if we even need an end function
        var pidX = xPID.calculate(choice)
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
    

