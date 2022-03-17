// SummitRobotics on Github
// https://raw.githubusercontent.com/SummitRobotics/FRC2022/main/src/main/java/frc/
// https://github.com/wpilibsuite/allwpilib/tree/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/frisbeebot

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExtendIntake;
import frc.robot.commands.RetractIntake;
import frc.robot.commands.SpinShooter;
import frc.robot.commands.SpinSpinner;
import frc.robot.commands.Uptake;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

/**
* This class is where the bulk of the robot should be declared. Since
* Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in
* the {@link Robot}
* periodic methods (other than the scheduler calls). Instead, the structure of
* the robot (including
* subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer 
{
    
    //private final CommandScheduler scheduler;
    
    // Subsystems
    public final static DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
    public final static ShooterSubsystem m_shooter = new ShooterSubsystem();
    public final static IntakeSubsystem m_intake = new IntakeSubsystem();
    //private final ClimberSubsystem m_climber = new ClimberSubsystem();
    public final static VisionSubsystem m_vision = new VisionSubsystem();
    private final Joystick m_driverController = new Joystick(0);
    
    //private final Command m_autoCommand = new InstantCommand( m_shooter::enable, m_shooter )
    //.andThen(() -> {m_shooter.setShooterMotor(0); });
    
    /**
    * The container for the robot. Contains subsystems, OI devices, and commands.
    */
    public RobotContainer() 
    {
        configureButtonBindings();

        //m_drivetrain.setDefaultCommand(new RunCommand(() -> DrivetrainSubsystem.ArcadeDrive(m_driverController, m_drivetrain)));
        //autoInit = new SequentialCommandGroup( {} );
        //teleInit = new SequentialCommandGroup( {} );
        //initTelemetry();
        m_drivetrain.setDefaultCommand(new ArcadeDrive(m_driverController, m_drivetrain));
    }
    
    
    
    private void configureButtonBindings() 
    {
        new JoystickButton(m_driverController, Constants.kShootBtn).whenPressed( new SpinShooter(m_driverController) );
        new JoystickButton(m_driverController, Constants.kSpinnerBtn).whenPressed( new SpinSpinner(m_driverController) );
        new JoystickButton(m_driverController, Constants.kIntakeRetractBtn).whenPressed( new RetractIntake(m_driverController) );
        new JoystickButton(m_driverController, Constants.kIntakeExtendBtn).whenPressed( new ExtendIntake(m_driverController) );
        new JoystickButton(m_driverController, Constants.kUptakeBtn).whenPressed( new Uptake(m_driverController) );
        
        //m_vision.setString( "[OI>Buttons] Created" );
        
    }
    
    /**
    * Use this method to init all the subsystems' telemetry stuff.
    */
    //private void initTelemetry() 
    //{
        //SmartDashboard.putData("PDP", pdp);
        //SmartDashboard.putData("PCM", pcm);
        // SmartDashboard.putData("Drivetrain", drivetrain);
        // SmartDashboard.putData("Lemonlight", targetingLimelight);
        // SmartDashboard.putData("Lemonlight", ballDetectionLimelight);
        //SmartDashboard.putData("Shooter", m_shooter);
        //SmartDashboard.putData("Conveyor", conveyor);
        // SmartDashboard.putData("Intake", intake);
        // SmartDashboard.putData("Color Sensor", colorSensor);
        // SmartDashboard.putData("Lidar", lidar);
        //SmartDashboard.putData("Climb", climb);
    //}
    
    /**
    * runs when the robot gets disabled.
    */
    public void disabledInit() 
    {
        
    }
    
    /**
    * runs when the robot is powered on.
    */
    public void robotInit() 
    {
        //gyro.calibrate();
        //ShuffleboardDriver.init();
        
        
    }
    
    /**
    * runs once every ~20ms when in teleop.
    */
    public void teleopPeriodic() 
    {
    }
    
    /**
    * runs when robot is inited to teleop.
    */
    public void teleopInit() 
    {
        //scheduler.schedule(teleInit);
    }
    
    /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
    public Command getAutonomousCommand()
    {
        return null;
        // // An ExampleCommand will run in autonomous
        //  // sets up all the splines so we dont need to spend lots of time
        // // turning the json files into trajectorys when we want to run them
        // String ball1 = "paths\1.path";
        // try {
            //     Command fball1 = Functions.splineCommandFromFile(drivetrain, ball1);
            //     // possible 4 ball auto
            //     auto = new SequentialCommandGroup(
            //             autoInit,
            //             new PrintCommand("paiosuibsfub"),
            //             new ShooterAtStart(shooter, conveyor).withTimeout(10),
            //             new PrintCommand("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"),
            //             fball1
            //             // fullAutoShooterAssembly,
            //             // fullAutoIntake.get(),
            //             // fullAutoShooterAssembly,
            //             // fullAutoIntake.get(),
            //             // fullAutoShooterAssembly
            //             );
            
            //     return auto;
            // } catch (Exception e) {
                //     System.out.println("An error occured when making autoInit: " + e);
                // }
                
                // return new SequentialCommandGroup(
                //autoInit,
                //new ShooterAtStart(shooter, conveyor).withTimeout(10),
                //new InstantCommand(() -> {drivetrain.setLeftMotorPower(-0.3); drivetrain.setRightMotorPower(-0.3);}),
                //new DriveByTime(drivetrain, 3, -0.3)
                //new InstantCommand(() -> drivetrain.stop())
                // fullAutoShooterAssembly,
                // fullAutoIntake.get(),
                // fullAutoShooterAssembly,
                // fullAutoIntake.get(),
                // fullAutoShooterAssembly
                // );
                
    }
} 
        
