package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class RetractIntake extends CommandBase
{
    // the subsystems that this command accesses
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;
    
    // private final Joystick mDriverController;
    public RetractIntake(Joystick m_driver_controller)
    {
        mDriverController = m_driver_controller;
        mIntakeSubsystem = RobotContainer.m_intake;
        //addRequirements(Robot.m_intake);
    }
    
    
    @Override
    public void initialize()
    {
        // Stop the motor before reversing direction
        RobotContainer.m_vision.setString( "[RETRACT INTAKE] Initializing" );
        mIntakeSubsystem.setActuatorMotor(0);
        RobotContainer.m_vision.setString( "[RETRACT INTAKE] Zeroed" );
        try 
        {
            wait(250);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorRetractSpeed);
        System.err.println( "[RETRACT INTAKE] command initialized..." );
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton(Constants.kIntakeRetractBtn);
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);
    }
}
