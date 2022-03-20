/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;


public class ArcadeDrive extends CommandBase {
  //Creates a new ArcadeDrive.

  // changed from pivate to public
  public Joystick mDriverController;
  public static DrivetrainSubsystem m_drivetrain;
  
  public ArcadeDrive(Joystick m_driverController, DrivetrainSubsystem m_driveTrain) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = m_driveTrain;
    mDriverController = m_driverController;

    addRequirements(RobotContainer.m_drivetrain);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    m_drivetrain.arcadeDrive(0, 0);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double moveSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_ROTATE_AXIS);
    
    m_drivetrain.arcadeDrive(0.5*rotateSpeed, 0.5*moveSpeed);
    //these may be swapped
    //changed rotate speed multiplier from .75 to .1
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    /* stops the motors */
    m_drivetrain.arcadeDrive(0, 0);
  }
  
  @Override
  public boolean isFinished() 
  {
    // because this should run indefinitely
    // it should _always_ return false
    // for a drive_train
    return false;
  }
}
