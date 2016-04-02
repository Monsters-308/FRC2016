package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousApproachGoal extends CommandGroup {

	public AutonomousApproachGoal() {
		addSequential(new AutonomousTimedRotate(0.5, 0.8));
		addSequential(new AutonomousTimedDrive(1.0, 1.5));
		addSequential(new turnToTarget(true));
		addSequential(new AutonomousGoalDrive(0.4));
		addSequential(new turnToTarget(false));
	}

}
