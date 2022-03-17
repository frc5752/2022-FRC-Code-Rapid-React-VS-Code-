package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ExtendIntake extends CommandBase
{
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;

    // the subsystems that this command accesses
    public ExtendIntake(Joystick m_driver_controller)
    {
        mIntakeSubsystem = RobotContainer.m_intake;
        mDriverController = m_driver_controller;
        //addRequirements(Robot.m_intake);
    }
    
    @Override
    public void initialize()
    {
        // stop the motor before changing direction
        RobotContainer.m_vision.setString( "[EXTEND INTAKE] Initializing..." );
        mIntakeSubsystem.setActuatorMotor(0);
        RobotContainer.m_vision.setString( "[EXTEND INTAKE] Zeroed" );
        try 
        {
            wait(250);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorExtendSpeed);
        RobotContainer.m_vision.setString( "[EXTEND INTAKE] Initialized" );

    }
    
    @Override
    public void execute()
    {
        // nothing really need to be done here
        // the Actuator motor is turned on during
        // initialize(); and then turned off during end();
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton( Constants.kIntakeExtendBtn );
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);

        // maybe we should add the "retract" command to the scheduler here?
    }
}
