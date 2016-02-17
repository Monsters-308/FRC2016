package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousShootBall extends CommandGroup {

	public AutonomousShootBall() {
		//set baffle - parallel
		addSequential(new AutonomousSetBaffle(true));
		
		//adjust ball - parallel 
		addParallel(new AutonomousAdjustBall());
		
		//rev up motor - sequential
		
		//run intake
		//stop
	}

}
