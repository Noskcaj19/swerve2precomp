// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DefaultShooter;
import frc.robot.command.DefaultSwerve;
import frc.robot.command.Move;
import frc.robot.command.autolime.AutoDrive;
import frc.robot.command.autolime.LimelightlightDrive;
import frc.robot.sds.ModuleConfiguration;
import frc.robot.sds.SdsModuleConfigurations;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;
import frc.robot.subsytems.SwerveSubsystem;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import com.pathplanner.lib.auto.AutoBuilder;

public class RobotContainer {

  private final SendableChooser<Command> autoChooser;
  private final Robot robot = new Robot();

  // controllers
  private final Joystick primaryJoy = new Joystick(0);
  private final Joystick SecondJoy = new Joystick(1);

  // TODO subsystems
  private final SwerveSubsystem swerveSub = new SwerveSubsystem();
  private final Mouth mouth = new Mouth();
  // private final Shooter shooterSub = new Shooter();

  // commands
  private final DefaultSwerve defaultSwerve = new DefaultSwerve(primaryJoy, swerveSub);
  private final Move intakeTransport = new Move(mouth, primaryJoy);

  public RobotContainer() {
    swerveSub.setDefaultCommand(defaultSwerve);
    configureBindings();

    Shooter shooterSub = new Shooter();
    AutoDrive step = new AutoDrive(swerveSub);
    //push commands to pathweaver auto
    NamedCommands.registerCommand("drive", step);

    autoChooser = AutoBuilder.buildAutoChooser();

    Shuffleboard.getTab("autoChooser").add(autoChooser);
    
  }

  private void configureBindings() {
    new JoystickButton(primaryJoy, 7).whileTrue(new LimelightlightDrive(swerveSub));
    new JoystickButton(primaryJoy, 8).whileTrue(new PathPlannerAuto("New New Auto"));
  }

  public Command getAutonomousCommand() {
    var command = autoChooser.getSelected();

    if(command != null){
      return command;
    }
    else{
      return new Command() {
      };
    }
  }
}
