package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.ShooterSubsystem;

public class SpinupAndShoot extends ParallelCommandGroup
{
	// ParallelCommandGroup commands happen in parallel
	// ... that means that they all happen at the same
	// time.
	//  That's why this command is done in such a weird way.
	//  The DelayUptake command is a sequential command... the
	// list of commands that it has all happen one after the other
	// NOT at the same time.
	// The Delay Uptake(3) command waits for 3 seconds then
	// turns on the "uptake" motor.

	// Here's the timing with SpinShooterinAuto on top and DelayUptake on the bottom

	// t=  0    1    2   3   4    5 
	//SS=************************** 
	//DU=................********** (where the .'s represent waiting)
    public SpinupAndShoot(ShooterSubsystem m_SpinnerSubsystem)
    {
       addCommands(
		   new SpinShooterInAuto(5),
       new DelayUptake(3)
       );
    }
}
