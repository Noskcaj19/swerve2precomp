// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.command.autolime.OneAutoToRuleThemAll;

public class Robot extends TimedRobot {

  private Command autonomousCommand;
  private RobotContainer robotContainer;
  // private DigitalInput dio = new DigitalInput(1);

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    // System.out.println("==== before commands ====");
    CommandScheduler.getInstance().run();
    // System.out.println("<<<< after commands <<<<");
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {

    // if (dio.get()) {
    // robotContainer.resetFieldOrientation();
    // }

  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void autonomousExit() {
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void testExit() {
  }
}
