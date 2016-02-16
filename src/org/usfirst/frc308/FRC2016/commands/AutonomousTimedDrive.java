package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTimedDrive extends Command {

	double power;
	double timetorun;
	Timer timer;
	
	/**
	 * starts a command that drives robot for a specific amount of time
	 * @param motorpower the motor power to drive from -1.0 to 1.0
	 * @param time how long to drive in seconds
	 */
	public AutonomousTimedDrive(double motorpower, double time) {
		power = motorpower;
		timetorun = time;
		timer = new Timer();
		requires(Robot.chasis);
	}

	@Override
	protected void initialize() {
		Robot.chasis.setupBasicDrive();
		timer.start();
	}

	@Override
	protected void execute() {
		Robot.chasis.basicDrive(power, 0);
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
		Robot.chasis.basicDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
