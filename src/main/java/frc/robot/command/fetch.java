package frc.robot.command;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.subsytems.*;

public class fetch {
    //i want robot dog

    private ProfiledPIDController pidY = new ProfiledPIDController(
  2,
  0.0,
  0,
  new
  TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond
  / 4, 2.5));
  private ProfiledPIDController pidX = new ProfiledPIDController(
  2,
  0.0,
  0,
  new
  TrapezoidProfile.Constraints(Constants.DriveConstants.MaxVelocityMetersPerSecond
  / 4, 2.5));

private ProfiledPIDController pidTheta = new ProfiledPIDController(
      .06,
      0.0,
      0,
      new TrapezoidProfile.Constraints(Constants.DriveConstants.MaxAngularVelocityRadiansPerSecond / 4, 1.5));

    
    private static Pose3d getTagPose() {
        var pose = LimelightHelpers.getTargetPose3d_RobotSpace("");
        return new Pose3d(pose[0], -pose[1], pose[2], new Rotation3d(pose[3], pose[4], pose[5]))
    }

    public void AutoFaceApril3d(SwerveSubsystem ds) {
    pidX.setGoal(new State(0, 0));
    pidY.setGoal(new State(0.9, 0));
    pidTheta.setGoal(new State(0, 0));

    addRequirements(ds);
    this.ds = ds;
  }

}


//plan: robot looks for note and faces it
//you throw the note and it turns around to find it
//it looks at it
//when button is pushed it goes to it
//when another button is pushed it picks it up
//then you can push a button to have it retrace its steps it took to go to the 
