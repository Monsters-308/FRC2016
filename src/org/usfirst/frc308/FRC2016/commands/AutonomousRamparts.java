package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRamparts extends CommandGroup {

	public AutonomousRamparts() {
		addSequential(new AutonomousShift(false));
		addParallel(new AutonomousSetPlatform(true));
		addParallel(new AutonomousSetArm(-0.9, 2.0));
		addSequential(new AutonomousTimedDrive(-1.0, 5.0));
		addParallel(new AutonomousSetArm(1.0, 2.0));
	}

}
