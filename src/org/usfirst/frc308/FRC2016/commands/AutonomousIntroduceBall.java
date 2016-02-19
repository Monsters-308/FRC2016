package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousIntroduceBall extends Command {

	double intakePower;
	Timer intakeTimer;

	public AutonomousIntroduceBall(double intakeSpeed) {
		requires(Robot.intake);
		intakePower = intakeSpeed;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		intakeTimer = new Timer();
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
		if (Robot.intake.getOpticalSensor() == true && intakeTimer.get() != 0) {
			intakeTimer.start();
		}
        if (intakeTimer.get() > 2) {
        	return true;
        }else{
        	return false;
        }
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
