package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousGoalDrive extends Command {

	double power;

	/**
	 * starts a command that drives robot for a specific amount of time
	 * 
	 * @param motorpower
	 *            the motor power to drive from -1.0 to 1.0
	 * @param time
	 *            how long to drive in seconds
	 */
	public AutonomousGoalDrive(double motorpower) {
		power = motorpower;
		requires(Robot.chasis);
	}

	@Override
	protected void initialize() {
		Robot.chasis.setupBasicDrive();
	}

	@Override
	protected void execute() {
		Robot.chasis.displayChasisData();
		Robot.chasis.basicDrive(power, 0);
	}

	@Override
	protected boolean isFinished() {
		double[] targets = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerY", new double[0]);
		if (targets.length > 0 && targets[0] <= 65) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		Robot.chasis.basicDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
