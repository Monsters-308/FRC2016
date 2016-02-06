// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
// Max
// Matteo
package org.usfirst.frc308.FRC2016.subsystems;

import java.util.Set;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;
import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.*;

import com.sun.org.apache.xpath.internal.functions.Function;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private final Solenoid shooterLift = RobotMap.pneumaticsshooterLift;
	private final Solenoid shooterBaffle = RobotMap.pneumaticsshooterBaffle;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new teleopShooter());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void displayOpticalSensorData() {
		SmartDashboard.putBoolean("high sensor", highOpticalSensor.get());
		SmartDashboard.putBoolean("low sensor", lowOpticalSensor.get());
		SmartDashboard.putNumber("shooter speed", shootMotor1.getEncVelocity());
	}

	/**
	 * sets the lift up or down
	 * 
	 * @param setpoint
	 *            true to set it up, false to set it down
	 */
	public void setLift(boolean setpoint) {
		shooterLift.set(setpoint);
	}

	/**
	 * keeps ball between optical sensors
	 */
	public void adjustBall() {
		SmartDashboard.putNumber("Intake Motor", Robot.shooter.intakeMotor.get());// MonstersDebug
		// If lowOpticalSensor is false and highOpticalSensor is true
		if (lowOpticalSensor.get() == true && highOpticalSensor.get() == false) {
			// then run intakeMotor reverse intakeAdjustSpeed
			Robot.shooter.intakeMotor.set(-RobotConstants.intakeAdjustSpeed);
		} else if (lowOpticalSensor.get() == false && highOpticalSensor.get() == true) {
			// Else if lowOpticalSensor is true and highOpticalSensor is false
			// then run intakeMotor forward intakeAdjustSpeed
			Robot.shooter.intakeMotor.set(RobotConstants.intakeAdjustSpeed);
		} else {
			// Else set intakeMotor to 0 (stop)
			Robot.shooter.intakeMotor.set(0);
		}

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
		if (highOpticalSensor.get() == false) {
			Robot.shooter.intakeMotor.set(RobotConstants.intakeGrabSpeed);
		} else {
			Robot.shooter.intakeMotor.set(0);
		}
		// else set intakeMotor to 0

	}

	/**
	 * shoots the ball
	 */
	public void shootBallHigh() {
		/*
		 * if shooter not up to speed and both optical sensors are true, then
		 * set shootMotor to shooterSpeed
		 * 
		 * else if current shooter speed is within shootingTolerance , then set
		 * intakeMotor to intakeShooterSpeed
		 * 
		 * else set shootMotor 0
		 */

		/* ADD PNEUMATIC OBJECT AND CODE TO TO LOCK THE SHOOTING BAFFLE */

		if (Math.abs(RobotConstants.shooterSpeed
				- Robot.shooter.shootMotor1.getEncVelocity()) > RobotConstants.shooterTolerance
				&& (highOpticalSensor.get() == true && lowOpticalSensor.get() == true)) {
			Robot.shooter.shootMotor1.set(RobotConstants.shooterSpeed);
		} else if (Math.abs(RobotConstants.shooterSpeed
				- Robot.shooter.shootMotor1.getEncVelocity()) < RobotConstants.shooterTolerance) {
			Robot.shooter.intakeMotor.set(RobotConstants.intakeShooterSpeed);
		} else {
			Robot.shooter.shootMotor1.set(0);
		}
	}

	public void ejectBall() {
		// set intakeMotor to negative intakeEjectSpeed

		Robot.shooter.intakeMotor.set(-RobotConstants.intakeEjectSpeed);

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

	/**
	 * Sets shooting baffle up or down
	 * 
	 * @param state
	 *            true = up false = down
	 */
	public void setBaffle(boolean state) {
		Robot.shooter.shooterBaffle.set(state);

	}
}
