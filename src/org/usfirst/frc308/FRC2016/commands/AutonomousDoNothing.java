package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDoNothing extends CommandGroup {

	public AutonomousDoNothing() {
		addSequential(new AutonomousShift(false));
		addParallel(new AutonomousSetArm(1.0, 2.0));
	}

}
