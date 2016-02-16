package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousAdjustBall extends Command{

	@Override
	protected void initialize() {
		Robot.shooter.setupAutonomousIntake();
	}

	@Override
	protected void execute() {
		Robot.shooter.displayOpticalSensorData();
		Robot.shooter.adjustBall();
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
