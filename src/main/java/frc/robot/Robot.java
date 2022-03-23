/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ArcadeDrive_timed;

/*
* The VM is configured to automatically run this class, and to call the functions corresponding to
* each mode, as described in the TimedRobot documentation. If you change the name of this class or
* the package after creating this project, you must also update the build.gradle file in the
* project.
*/
public class Robot extends TimedRobot 
{
  private Command m_autonomousCommand;
  private RobotContainer robotContainer;

  //public static DrivetrainSubsystem m_drivetrain;
  
  //public static IntakeSubsystem m_intake;
  //public static ShooterSubsystem m_shooter;
  //public static DriverStation m_driverstation;
  //public static VisionSubsystem m_vision;
  //public static Joystick m_driver_controller;
  //public static OI oi;
  
  //public static SendableChooser<Command> autoChooser;
  
    
  /**
  * This function is run when the robot is first started up and should be used for any
  * initialization code.
  */
  @Override
  public void robotInit() 
  {
    robotContainer = new RobotContainer();
    robotContainer.robotInit();

    //m_vision = VisionSubsystem.getInstance();
    //m_drivetrain = DrivetrainSubsystem.getInstance();
    //m_intake = IntakeSubsystem.getInstance();
    //m_shooter = ShooterSubsystem.getInstance();
    //m_driver_controller = new Joystick(Constants.Controls.DRIVE_CONTROLS);
    //oi = OI.getInstance();

    //m_drivetrain.setDefaultCommand(new ArcadeDrive(m_driver_controller));
  }

  /**
  * This function is called every robot packet, no matter the mode. Use this for items like
  * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
  *
  * This runs after the mode specific periodic functions, but before
  * LiveWindow and SmartDashboard integrated updating.
  */
  @Override
  public void robotPeriodic() 
  {
    CommandScheduler.getInstance().run();
  }
  
  /**
  * This function is called once each time the robot enters Disabled mode.
  */
  @Override
  public void disabledInit()
  {
    robotContainer.disabledInit();
  }
  
  @Override
  public void disabledPeriodic() 
  {
  }
  
  /**
  * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
  */
  @Override
  public void autonomousInit() 
  {

    m_autonomousCommand = robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.schedule();
    }
  }
  
  /**
  * This function is called periodically during autonomous.
  */
  @Override
  public void autonomousPeriodic() 
  {
  }
  
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.cancel();
    }
    robotContainer.teleopInit();
  }
  
  /**
  * This function is called periodically during operator control.
  */
  @Override
  public void teleopPeriodic() 
  {
    robotContainer.teleopPeriodic();
  }
    
  
  @Override
  public void testInit() 
  {
    CommandScheduler.getInstance().cancelAll();
    CommandScheduler.getInstance().enable();
    teleopInit();  
  }
  
  
  //This function is called periodically during test mode.  
  @Override
  public void testPeriodic() 
  {
    teleopPeriodic();
    //CommandScheduler.getInstance().run();
  }
}
