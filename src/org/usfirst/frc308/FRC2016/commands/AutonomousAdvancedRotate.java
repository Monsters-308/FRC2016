package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousAdvancedRotate extends Command {

	double p; // the setpoint we are rotating to
	double v; // the maximum speed that the robot will reach
	double a; // the maximum acceleration that the robot can sustain
	double t; // time spent accelerating and decelerating combined
	double ct; // time spent cruising at maximum speed

	Timer timer;

	public AutonomousAdvancedRotate(double angle, double maxacceleration, double maxspeed) {
		p = angle;
		v = maxspeed;
		a = maxacceleration;
		requires(Robot.chasis);
	}

	@Override
	protected void initialize() {
		Robot.chasis.setupBasicDrive();
		// if we wont get up to the robot's max speed before we start slowing
		if (128.0 * v * v / (45.0 * Math.sqrt(3.0) * a) >= p) {
			// calculate the highest speed we will reach
			v = Math.sqrt(45.0 * Math.sqrt(3.0) * p * a / 128.0);
			// calculate time while accelerating
			t = 16.0 * v / (3.0 * Math.sqrt(3.0) * a);
			// no cruise time at top speed because it is not reached
			ct = 0;
		} else {// we will reach the robot's max speed
			// calculate time while accelerating
			t = 16.0 * v / (3.0 * Math.sqrt(3.0) * a);
			// calculate additional time cruising at top speed
			ct = (p - 128.0 * v * v / (45.0 * Math.sqrt(3.0) * a)) / v;
		}
		timer = new Timer();
		timer.start();
	}

	@Override
	protected void execute() {
		Robot.chasis.autonomousAdvancedRotate(timer.get(), p, t, ct, v);
	}

	@Override
	protected boolean isFinished() {
		if (timer.get() <= t + ct + 1.0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		Robot.chasis.basicDrive(0, 0);
		timer.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
