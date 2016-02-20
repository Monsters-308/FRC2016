package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class teleopLights extends Command {

	public teleopLights() {
		requires(Robot.lights);
	}

	@Override
	protected void initialize() {
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
			Robot.lights.setBottom(false, true);
		} else if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			Robot.lights.setBottom(true, false);
		}
	}

	@Override
	protected void execute() {

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
