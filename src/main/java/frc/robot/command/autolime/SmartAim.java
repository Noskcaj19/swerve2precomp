// package frc.robot.command.autolime;

// import edu.wpi.first.math.controller.ProfiledPIDController;
// import edu.wpi.first.math.trajectory.TrapezoidProfile;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.LimelightHelpers;
// import frc.robot.subsytems.Shooter;
// import frc.robot.subsytems.SwerveSubsystem;
// import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
// import edu.wpi.first.wpilibj.Joystick;

// public class SmartAim extends Command {

// double distance;
// double rotation;
// double speed;
// private SwerveSubsystem swerveSub;
// private Shooter shoot;
// private final Joystick primaryJoy;

// double ku = 3.0;
// double tu = 0.8;

// private ProfiledPIDController distancePID = new ProfiledPIDController(
// .6 * ku,
// .5 * tu,
// .125 * tu,
// new TrapezoidProfile.Constraints(5, 3 / 1.5));
// private ProfiledPIDController xPID = new ProfiledPIDController(
// .6 * ku,
// .5 * tu,
// .125 * tu,
// new TrapezoidProfile.Constraints(5, 3 / 1.5));

// final double getZontal() {
// return (LimelightHelpers.getTX("") / 27);
// // return (x.getDouble(160)/160)-1;
// // horizontal offset
// }

// double getSpace(int index) {
// return (LimelightHelpers.getTargetPose_RobotSpace("")[index]);
// // return (x.getDouble(160)/160)-1;
// // whatever the distance is
// // returns the specific distance value we want so we can pid it???
// // why is everything so
// }

// private SmartAim(SwerveSubsystem swerveSub, double distance, double rotation,
// double speed, Joystick inJoy) {

// addRequirements(swerveSub);
// this.swerveSub = swerveSub;
// this.distance = distance;
// this.rotation = rotation;
// this.speed = speed;
// this.primaryJoy = inJoy;

// }

// @Override
// public void initialize() {

// }

// @Override
// public void execute() {

// if(primaryJoy.getRawButton(10)){
// if (LimelightHelpers.getTV("")) {
// double tagID = LimelightHelpers.getFiducialID("");
// if (tagID == "amp") {

// distancePID.setGoal(new State(2, 0));

// double xOff = xPID.calculate(getZontal());

// double yOff = -distancePID.calculate(getSpace(2));
// swerveSub.drive(yOff, xOff, 0, false);

// if(getZontal() < 0.08){
// shoot.shootAmp();
// }
// }
// else if(tagID == "speaker"){
// shoot.setSpeakerSpeed();
// distancePID.setGoal(new State(3,0));

// double xOff = xPID.calculate(getZontal());

// double yOff = -distancePID.calculate(getSpace(2));
// swerveSub.drive(yOff, xOff, 0, false);

// if(getZontal() < 0.08){
// shoot.shootAmp();
// }
// }
// }
// }

// // @Override
// // public void end(boolean interrupted) {

// // }

// // @Override
// // public boolean isFinished() {
// // return false;
// // }
// // }
// }
