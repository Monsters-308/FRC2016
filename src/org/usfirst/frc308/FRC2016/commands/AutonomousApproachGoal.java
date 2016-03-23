package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousApproachGoal extends CommandGroup {

	public AutonomousApproachGoal() {
		addSequential(new AutonomousRotate(10.0, 2.0));
		addSequential(new AutonomousTimedDrive(1.0, 2.0));
		addSequential(new turnToTarget());
		addSequential(new AutonomousGoalDrive(0.3));
	}

}
