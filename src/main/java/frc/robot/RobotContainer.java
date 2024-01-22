// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.command.DefaultSwerve;
import frc.robot.sds.ModuleConfiguration;
import frc.robot.sds.SdsModuleConfigurations;
import frc.robot.subsytems.SwerveSubsystem;

public class RobotContainer {

  private final Robot robot = new Robot();

  // controllers
  private final Joystick primaryJoy = new Joystick(0);
  private final Joystick SecondJoy = new Joystick(1);

  // subsystems
  private final SwerveSubsystem swerveSub = new SwerveSubsystem();
  // private final SwerveModule swerveModule = new SwerveModule(null, null);

  // commands
  private final DefaultSwerve defaultSwerve = new DefaultSwerve(primaryJoy, swerveSub);

  public RobotContainer() {
    swerveSub.setDefaultCommand(defaultSwerve);
    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
