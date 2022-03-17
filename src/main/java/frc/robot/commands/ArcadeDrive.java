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
  private Joystick mDriverController;
  private static DrivetrainSubsystem m_drivetrain;
  
  public ArcadeDrive(Joystick m_driver_controller) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = RobotContainer.m_drivetrain;
    mDriverController = m_driver_controller;

    addRequirements(RobotContainer.m_drivetrain);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    RobotContainer.m_vision.setString( "[ARCADE DRIVE] Initialized" );
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double moveSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_ROTATE_AXIS);
    //Robot.m_vision.setString( rotateSpeed. );
    m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
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
