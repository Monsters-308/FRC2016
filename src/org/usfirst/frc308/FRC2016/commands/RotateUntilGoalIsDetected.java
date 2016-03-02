package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class RotateUntilGoalIsDetected extends Command {

	double rot;

	public RotateUntilGoalIsDetected(double rotation) {
		requires(Robot.chasis);
		rot = rotation;
	}

	@Override
	protected void initialize() {
		Robot.chasis.setupBasicDrive();
	}

	@Override
	protected void execute() {
		Robot.chasis.basicDrive(0, rot);
	}

	@Override
	protected boolean isFinished() {
		if (NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerX", new double[0]).length > 0) {
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
