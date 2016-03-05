package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShift extends Command {

	boolean State;

	public AutonomousShift(boolean state) {
		requires(Robot.chasis);
		State = state;
	}

	@Override
	protected void initialize() {
		if (State) {
			Robot.chasis.shiftUp();
		} else {
			Robot.chasis.shiftDown();
		}
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
		end();
	}

}
