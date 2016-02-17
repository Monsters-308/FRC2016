package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousAdjustBall extends Command{

	@Override
	protected void initialize() {
		Robot.intake.setupAutonomousIntake();
	}

	@Override
	protected void execute() {
		Robot.intake.displayOpticalSensorData();
		Robot.intake.adjustBall();
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
