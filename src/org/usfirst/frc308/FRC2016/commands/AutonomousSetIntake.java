package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSetIntake extends Command {

	double intakePower;
	Timer intakeTimer;

	public AutonomousSetIntake(double intakeSpeed) {
		intakePower = intakeSpeed;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.intake.setupIntake();
		Robot.intake.setIntake(intakePower);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
