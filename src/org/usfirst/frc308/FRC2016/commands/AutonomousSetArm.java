package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSetArm extends Command {

	double p;
	double t;
	double s;
	Timer timer;

	public AutonomousSetArm(double position, double time) {
		p = position;
		t = time;
		timer = new Timer();
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		Robot.arm.resetupArmLight();
		s = Robot.arm.getArmSetpoint();
		timer.start();
	}

	@Override
	protected void execute() {
		Robot.arm.displayArmData();
		Robot.arm.setArmPosition(s + (p - s) * timer.get() / t);
	}

	@Override
	protected boolean isFinished() {
		if (timer.get() >= t) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
		end();
	}

}
