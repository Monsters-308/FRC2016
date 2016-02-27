package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class testShooter extends Command {

	public testShooter() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.setupShooter();
		Robot.shooter.setShootPower(9000.0);
	}

	@Override
	protected void execute() {
		Robot.shooter.displayOpticalSensorData();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
