package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;

public class teleopIntake extends Command {

	public teleopIntake() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.intake.setupIntake();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		// if buttonB is pressed, call runIntakeMotor()
		Robot.intake.displayOpticalSensorData();

		if (RobotConstants.introduceBall) {
			Robot.intake.setIntake(RobotConstants.intakeShooterSpeed);
		} else if (Robot.oi.joystick2.getRawButton(RobotConstants.runIntakeMotor)) {
			Robot.intake.runIntakeMotor();
		} else if (Robot.oi.joystick2.getRawButton(RobotConstants.ejectBall)) {
			Robot.intake.ejectBall();
		} else {
			Robot.intake.setIntake(0);
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
