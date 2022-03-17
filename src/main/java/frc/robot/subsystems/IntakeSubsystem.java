  package frc.robot.subsystems;

  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.Constants;

  import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


  /* this subsystem is for the 2 motors that control the intake of a ball */
  /* there's a motor that spins to get the ball - called the 'spinner' */
  /* there's a motor that controls the extending and retracting of the arms */
  /* it's called the actuator */
  public class IntakeSubsystem extends SubsystemBase 
  {
    public static IntakeSubsystem instance;
    public static WPI_VictorSPX mSpinnerMotor;
    public static WPI_TalonSRX mActuatorMotor;

    // constructor
    public IntakeSubsystem()
    {
      mSpinnerMotor = new WPI_VictorSPX( Constants.kMCIDSpinner );
      mActuatorMotor = new WPI_TalonSRX( Constants.kMCIDActuator );
    }
    
    // Subsystem methods - actions the robot can take - should be placed here.
    public void setActuatorMotor(double speed)
    {
      mActuatorMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public void setSpinnerMotor(double speed)
    {
      mSpinnerMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public static IntakeSubsystem getInstance()
    {
        if( instance == null )
        {
            instance = new IntakeSubsystem();
        }
        return instance;
    }

    @Override
    public void periodic() 
    {
      // This method will be called once per scheduler run
    }
    
    @Override
    public void simulationPeriodic() 
    {
      // This method will be called once per scheduler run during simulation
    }
  }