package frc.robot.command;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsytems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class LimelightlightDrive extends Command {

    private SwerveSubsystem swerveSub;
    private final PIDController turnPID;
    private final PIDController distancePID;
    private Limelight limelight;
    private XboxController primaryController;

    public LimelightlightDrive(SwerveSubsystem swerveSub, XboxController primaryController, Limelight limelight) {

<<<<<<< HEAD
         addRequirements(swerveSub);
         this.swerveSub = swerveSub;
         this.limelight = 
=======
        addRequirements(swerveSub);
        this.swerveSub = swerveSub;

 }
