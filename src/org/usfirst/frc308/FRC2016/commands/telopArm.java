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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

/**
 *
 */
public class telopArm extends Command {

	boolean pressed = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public telopArm() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.arm);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.arm.initArm();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.arm.displayArmData();
		// read joystick arm axis and pass it to setArmPosition() function
		if (Robot.oi.joystick2.getRawButton(5) && pressed == false) {
			RobotConstants.calibrationMode = !RobotConstants.calibrationMode;
			if (RobotConstants.calibrationMode == false) {
				Robot.arm.resetupArm();
			} else {
				Robot.arm.setCalibrationMode();
			}
			pressed = true;
		} else if (!Robot.oi.joystick2.getRawButton(5)) {
			pressed = false;
		}
		if (RobotConstants.calibrationMode) {
			Robot.arm.setArm(Robot.oi.joystick2.getZ());
		} else {
			if (Robot.oi.joystick2.getRawButton(1) && !RobotConstants.isAiming) {
				Robot.arm.setEnabled(false);
			} else {
				Robot.arm.setEnabled(true);
				Robot.arm.setArmPosition(Robot.oi.joystick2.getZ());
				if (Robot.arm.isNearEdge()) {
					Robot.arm.resetArmIntegral();
				}
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
