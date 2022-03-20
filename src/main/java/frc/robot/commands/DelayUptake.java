package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class DelayUptake extends SequentialCommandGroup
 {
public DelayUptake( double delay ) 
{
    addCommands( 
		new WaitCommand(delay),
        new UptakeInAuto(2)
    );
    
}
 }
