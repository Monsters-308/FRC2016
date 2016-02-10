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
public class teleopDrive extends Command {
	
	boolean directionToggleCheck = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public teleopDrive() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.chasis);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chasis.setupBasicDrive();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//TODO
		//if direction equals shooterDirection, call basicDrive normally
		//if direction equals intakeDirection, call basicDrive with -1 * joystick.getY()
		Robot.chasis.basicDrive(Robot.chasis.deadZone(Robot.oi.joystick1.getY()),
				Robot.chasis.deadZone(Robot.oi.joystick1.getX()));
		if (Robot.oi.joystick1.getRawButton(RobotConstants.chasisShiftUpButton) == true) {
			Robot.chasis.shiftUp();

		} else if (Robot.oi.joystick1.getRawButton(RobotConstants.chasisShiftDownButton) == true) {
			Robot.chasis.shiftDown();
		}
		//TODO
		//if reverseDirectionButton is pressed and directionToggleCheck is false,
			//if direction equals shooterDirection, set direction equal to intakeDirection
			//else if direction equals intakeDirection, set direction equal to shooterDirection
			//set directionToggleCheck equal to true
		//else if reverseDirectionButton is not pressed, set directionToggleCheck to false
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
