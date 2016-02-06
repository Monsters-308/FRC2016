package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestRotate extends CommandGroup {

	public TestRotate() {

	}

	@Override
	protected void initialize() {
		addSequential(new AutonomousRotate(180.0));
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
