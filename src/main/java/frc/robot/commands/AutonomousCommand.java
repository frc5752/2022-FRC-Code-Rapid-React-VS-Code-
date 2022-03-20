package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousCommand extends SequentialCommandGroup
{

    public AutonomousCommand(/* the subsystems get passed in here? */)
    {
       addCommands(
        new SpinShooter_timed(3),
        new UptakeAndShoot(),
        new ArcadeDrive_timed(-0.5, 3),
        new ExtendAndSpin(),
        new SpinSpinner_timed(1),
        new RetractAndSpin(),
        new ArcadeDrive_timed(0.5, 3),
        new SpinSpinner_timed(3),
        new UptakeAndShoot()
       );
    }
}
