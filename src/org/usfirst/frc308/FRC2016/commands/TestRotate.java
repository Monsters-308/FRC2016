package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.command.Command;

public class TestRotate extends Command{
	
	@Override
	protected void initialize() {
		new AutonomousRotate(180.0);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		
	}

}
