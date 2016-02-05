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

/**
 *
 */
public class teleopShooter extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	
	boolean lastpressedlift = false;
	
	public teleopShooter() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.shooter);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.shooter.setupShooter();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// call adjustBall()
		Robot.shooter.adjustBall();

		// if buttonA is pressed, call shootBall
		// else setShootPower 0
		if (Robot.oi.joystick2.getRawButton(1)) {// TODO which button?
			Robot.shooter.setBaffle(true);//lift baffle
			Robot.shooter.shootBallHigh();
			

		} else {
			Robot.shooter.setShootPower(0);
			Robot.shooter.setBaffle(false);
			

		}

		// if buttonB is pressed, call runIntakeMotor()
		if (Robot.oi.joystick2.getRawButton(4)){//TODO which button?
			Robot.shooter.runIntakeMotor();
		}
		if (Robot.oi.joystick2.getRawButton(3)){
			Robot.shooter.ejectBall();
		}
		
		//TODO
		// if lastpressedlift is false and buttonD is true,
		// call toggleLift()
		
		// set lastpressedlift equal to buttonD

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
