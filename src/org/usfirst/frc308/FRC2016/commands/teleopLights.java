package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class teleopLights extends Command {

	Timer t;

	public teleopLights() {
		requires(Robot.lights);
	}

	@Override
	protected void initialize() {
		t = new Timer();
		t.start();
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
			Robot.lights.setBottom(true, false);
		} else if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			Robot.lights.setBottom(false, true);
		}
	}

	@Override
	protected void execute() {
		if (Robot.intake.getOpticalSensor() && ((int) t.get()) % 2 == 0) {
			Robot.lights.setTop(false, false);
		} else {
			if (RobotConstants.direction) {
				Robot.lights.setTop(false, true);
			} else {
				Robot.lights.setTop(true, false);
			}
		}
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
