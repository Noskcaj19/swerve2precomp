// package frc.robot.command.autolime;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsytems.SwerveSubsystem;

// public class AutoDriveRotate extends Command{

//     private SwerveSubsystem swerveSub;
//     private double goalYDist;
//     private double goalYaw;
//     private double turnSpeed;
//     private double driveSpeed;
//     public AutoDriveRotate (SwerveSubsystem swerveSub, double goalYDist, double goalYaw, double turnSpeed, double driveSpeed) {
//         this.swerveSub = swerveSub;
//         this.goalYDist = goalYDist;
//         this.goalYaw = goalYaw;
//         this.turnSpeed = turnSpeed;
//         this.driveSpeed = driveSpeed;
//     }

//     @Override
//     public void execute(){

//         if (!isTurnFinished()){
//             turnSpeed = 0.3;
//         }
//         if (!isDriveFinished()){
//             driveSpeed = 0.3;
//         }
//         swerveSub.drive(0, driveSpeed, turnSpeed, isScheduled());
//     }

//     @Override
//     public void end(boolean interrupted){
//         swerveSub.drive(0,0,0,false);
//     }

//     public boolean isTurnFinished(){
//         double tempGY;
//         double tempCY;
//         double currentYaw = swerveSub.getYaw();
//         if(goalYaw < 0){
//             tempGY = -goalYaw;
//         }
//         else{
//             tempGY = goalYaw;
//         }
//         if(currentYaw < 0){
//             tempCY = -currentYaw;
//         }
//         else{
//             tempCY = currentYaw;
//         }
//         //yeah i dunno
//         // -90 -> 90
//         // -97 -> 97 
//         // 60 -> 60
//         // 97 > 90 -> true 
        
//         if (tempGY <= tempCY){
//             return true;
//         }
//         else{
//             return false;
//         }
    

//     }
//     public boolean isDriveFinished() {

//         double currentYDist = 
//         if
//     }
//     @Override
//     public boolean isFinished() {

//         if (isTurnFinished() && )
//     }
// }
