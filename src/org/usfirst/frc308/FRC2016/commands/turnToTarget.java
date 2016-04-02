// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc308.FRC2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

/**
 *
 */
public class turnToTarget extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	double setpointAngle = 0.0; // the angle we will rotate
	double t;
	boolean pass = true;
	boolean retry = false;
	Timer timer;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public turnToTarget(boolean Retry) {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		retry = Retry;
		requires(Robot.chasis);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	public void initialize() {
		RobotConstants.isAiming = true;
		double[] defaultValue = new double[0];
		double[] defaultValue2 = new double[0];
		double[] defaultValue3 = new double[0];
		double[] targets = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerX", defaultValue);
		double[] targets2 = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerY", defaultValue2);
		double[] targets3 = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("area", defaultValue3);
		int biggestTarget = Robot.vision.getLargestIndex(targets3);
		timer = new Timer();
		if (targets.length > 0) {
			SmartDashboard.putNumber("centerX", targets[biggestTarget]);
			SmartDashboard.putNumber("centerY", targets2[biggestTarget]);
			setpointAngle = (targets[biggestTarget] - 130.0) / 120.0 * (0.5 * RobotConstants.cameraFieldOfView);
			if (retry) {
				t = 1;
			} else {
				t = 2;
			}
			timer.start();
			Robot.chasis.setupBasicDrive();
			Robot.chasis.setRotatePID(setpointAngle);
		} else {
			pass = false;
			SmartDashboard.putNumber("centerX", -1);
			SmartDashboard.putNumber("centerY", -1);
		}
	}

	public void reInit() {
		pass = true;
		double[] defaultValue = new double[0];
		double[] defaultValue2 = new double[0];
		double[] defaultValue3 = new double[0];
		double[] targets = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerX", defaultValue);
		double[] targets2 = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerY", defaultValue2);
		double[] targets3 = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("area", defaultValue3);
		int biggestTarget = Robot.vision.getLargestIndex(targets3);
		timer = new Timer();
		if (targets.length > 0) {
			SmartDashboard.putNumber("centerX", targets[biggestTarget]);
			SmartDashboard.putNumber("centerY", targets2[biggestTarget]);
			setpointAngle = (targets[biggestTarget] - 130.0) / 120.0 * (0.5 * RobotConstants.cameraFieldOfView);
			t = 1;
			timer.start();
			Robot.chasis.setRotatePIDlight(setpointAngle);
		} else {
			pass = false;
			SmartDashboard.putNumber("centerX", -1);
			SmartDashboard.putNumber("centerY", -1);
		}
	}

	public boolean isFinished() {
		double[] targets = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("centerX", new double[0]);
		double[] targets3 = NetworkTable.getTable("GRIP/myContoursReport").getNumberArray("area", new double[0]);
		int biggestTarget = Robot.vision.getLargestIndex(targets3);
		if (targets.length == 0) {
			pass = false;
		}
		if (!pass) {
			if (retry || Robot.oi.joystick2.getRawButton(3)) {
				reInit();
			} else {
				return true;
			}
		} else if (timer.get() > t) {
			if (!retry && !Robot.oi.joystick2.getRawButton(3)) {
				return true;
			} else if (targets.length > 0 && Math.abs(targets[biggestTarget] - 130) <= 10) {
				return true;
			} else {
				reInit();
			}
		}
		return false;

	}

	@Override
	protected void execute() {
		Robot.chasis.displayChasisData();
		Robot.chasis.autonomousRotate();
	}

	@Override
	protected void end() {
		RobotConstants.isAiming = false;
	}

	@Override
	protected void interrupted() {
		end();
	}
}
