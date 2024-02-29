// package frc.robot.command.autolime;

// import edu.wpi.first.wpilibj2.command.Command;

// public class AutoRotate extends Command(){

// private SwerveSubsystem swerveSub;
// private double goalTurn;
// private double speed;
// // private boolean inverted;

//     public AutoRotate(SwerveSubsystem swerveSub, double goalTurn, double speed, boolean inverted){

//         addRequirements(swerveSub);
//         this.swerveSub =   swerveSub;
//         this.speed = speed;
//         this.goalTurn = goalTurn;

//     }

//     @Override
//     public void initialize(){
//         swerveSub.drive(speed, 0, goalTurn, false, 0, 0);
//     }

//     @Override
//     public void end(boolean interrupted) {
//         swerveSub.drive(0, 0, 0, false, 0, 0);
//     }

//     @Override
//     public boolean isFinished(){
//         //yeah i dunno
//     }
// }