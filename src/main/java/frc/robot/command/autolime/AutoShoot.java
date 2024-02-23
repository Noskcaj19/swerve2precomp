// package frc.robot.command.autolime;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.LimelightHelpers;
// import frc.robot.subsytems.Shooter;

// public class AutoShoot extends Command {

//     private final Shooter shootSub;

//     public AutoShoot(Shooter shootSub) {
//         this.shootSub = shootSub;
//     }

//     @Override
//     public void execute() {
//         double tagID = LimelightHelpers.getFiducialID("");
//         if(tagID == amp){
//             shootSub.shootAmp();
//         }
//         else if(tagID = speaker){
//             shootSub.shootSpeaker();
//         }
//     }

//     @Override
//     public void end(boolean interrupted){
        
//     }

//     @Override
//     public boolean isFinished() {
//         return false;
//     }

// }
