// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
// Matteo
package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final CANTalon shootMotor1 = RobotMap.shootershootMotor1;
	private final CANTalon intakeMotor = RobotMap.shooterintakeMotor;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	private final DigitalInput highOpticalSensor = RobotMap.highopticalsensor;
	private final DigitalInput lowOpticalSensor = RobotMap.lowopticalsensor;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new teleopShooter());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * keeps ball between optical sensors
	 */
	public void adjustBall() {
		/*If lowOpticalSensor is false and highOpticalSensor is true
		 *then run intakeMotor reverse intakeAdjustSpeed
		 *
		 *Else if lowOpticalSensor is true and highOpticalSensor is false
		 *then run intakeMotor forward intakeAdjustSpeed
		 *
		 *Else set intakeMotor to 0 (stop)
		 */
	}

	/**
	 * sets up shooter without PID
	 */
	public void setupShooter() {
		shootMotor1.changeControlMode(TalonControlMode.PercentVbus);
		intakeMotor.changeControlMode(TalonControlMode.PercentVbus);
	}

	

	
	
	/**
	 * runs the intake motor
	 */
	public void runIntakeMotor() {
		// if highOpticalSensor is false
		// set intakeMotor to constant intakeGrabSpeed

		// else set intakeMotor to 0

	}

	/**
	 * shoots the ball
	 */
	public void shootBallHigh() {
		/*
		 * if shooter not up to speed and both optical sensors are true, 
		 * then set shootMotor to shooterSpeed 
		 * 
		 * else if current shooter speed is within shootingTolerance , 
		 * then set intakeMotor to intakeShooterSpeed
		 * 
		 * else set shootMotor 0
		 */

	}
	public void ejectBall() {
		/*
		 * if buttonC is pressed, set intakeMotor to negative intakeEjectSpeed 
		 * 
		 * else set intakeMotor 0
		 */
		
	}

	/**
	 * sets the shooter power
	 * 
	 * @param power
	 *            the power to shoot, from -1.0 to 1.0
	 */
	public void setShootPower(double power) {
		shootMotor1.set(power);
	}
}
