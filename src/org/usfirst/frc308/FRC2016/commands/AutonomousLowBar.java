package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLowBar extends CommandGroup {

	public AutonomousLowBar() {
		addSequential(new AutonomousShift(false));
		addParallel(new AutonomousSetArm(-0.9, 2.0));
		addSequential(new AutonomousTimedDrive(1.0, 4.0));
		addParallel(new AutonomousSetArm(1.0, 2.0));
	}

}
