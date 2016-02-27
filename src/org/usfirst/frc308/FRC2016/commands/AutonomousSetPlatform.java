package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSetPlatform extends Command{
	
	boolean State;

	public AutonomousSetPlatform(boolean state) {
		requires(Robot.shooter);
		State = state;
	}

	@Override
	protected void initialize() {
		Robot.shooter.setLift(State);
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
