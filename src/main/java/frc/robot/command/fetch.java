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
import frc.robot.subsystems.SwerveSubsystem;

public class fetch {
    //i want robot dog

    private ProfiledPIDController pidY = new ProfiledPIDController(
  2,
  0.0,
  0,
  new
  TrapezoidProfile.Constraints(Constants.DriveConstants.kMaxVelocityMetersPerSecond
  / 4, 2.5));
  private ProfiledPIDController pidX = new ProfiledPIDController(
  2,
  0.0,
  0,
  new
  TrapezoidProfile.Constraints(Constants.DriveConstants.kMaxVelocityMetersPerSecond
  / 4, 2.5));
    private static pose3d getTagPos() {

    }
}
