package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousWait extends Command {

	double timetorun;
	Timer timer;
	
	public AutonomousWait(double time) {
		timetorun = time;
		timer = new Timer();
	}

	@Override
	protected void initialize() {
		timer.start();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		if (timer.get() >= timetorun) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		timer.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
