package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class calibrateGyro extends Command {

	public calibrateGyro() {

	}

	@Override
	protected void initialize() {
		Robot.chasis.basicDrive(0, 0);
	}

	@Override
	protected void execute() {
		Robot.chasis.basicDrive(0, 0);
	}

	@Override
	protected boolean isFinished() {
		SmartDashboard.putString("Gyro State", "Calibrating...");
		Robot.chasis.calibrateGyro();
		SmartDashboard.putString("Gyro State", "Done!");
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
