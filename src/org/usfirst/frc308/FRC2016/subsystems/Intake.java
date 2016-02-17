package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;
import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.teleopIntake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem {
	private final CANTalon intakeMotor = RobotMap.intakeMotor;
	private final DigitalInput highOpticalSensor = RobotMap.highopticalsensor;
	private final DigitalInput lowOpticalSensor = RobotMap.lowopticalsensor;
	
	public void setupIntake() {
		intakeMotor.changeControlMode(TalonControlMode.Speed);
		intakeMotor.setProfile(0);
		intakeMotor.setPID(RobotConstants.intakePIDKp, RobotConstants.intakePIDKi, RobotConstants.intakePIDKd,
				RobotConstants.intakePIDKf, RobotConstants.intakePIDIZone, RobotConstants.intakePIDRampRate, 0);
	}
	
	public void displayOpticalSensorData() {
		SmartDashboard.putBoolean("high sensor", highOpticalSensor.get());
		SmartDashboard.putBoolean("low sensor", lowOpticalSensor.get());
	}
	
	/**
	 * sets up intake for AutonomousAdjustBall
	 */
	public void setupAutonomousIntake() {
		intakeMotor.changeControlMode(TalonControlMode.Speed);
		intakeMotor.setProfile(0);
		intakeMotor.setPID(RobotConstants.intakePIDKp, RobotConstants.intakePIDKi, RobotConstants.intakePIDKd,
				RobotConstants.intakePIDKf, RobotConstants.intakePIDIZone, RobotConstants.intakePIDRampRate, 0);
	}
	
	/**
	 * keeps ball between optical sensors
	 */
	public void adjustBall() {
		SmartDashboard.putNumber("Intake Motor", Robot.intake.intakeMotor.get());// MonstersDebug
		// If lowOpticalSensor is false and highOpticalSensor is true
		if (lowOpticalSensor.get() == true && highOpticalSensor.get() == false) {
			// then run intakeMotor reverse intakeAdjustSpeed
			Robot.intake.intakeMotor.set(-RobotConstants.intakeAdjustSpeed);
		} else if (lowOpticalSensor.get() == false && highOpticalSensor.get() == true) {
			// Else if lowOpticalSensor is true and highOpticalSensor is false
			// then run intakeMotor forward intakeAdjustSpeed
			Robot.intake.intakeMotor.set(RobotConstants.intakeAdjustSpeed);
		} else {
			// Else set intakeMotor to 0 (stop)
			Robot.intake.intakeMotor.set(0);
		}
		}
	
	/**
	 * runs the intake motor
	 */
	public void runIntakeMotor() {
		// if highOpticalSensor is false
		// set intakeMotor to constant intakeGrabSpeed
		if (highOpticalSensor.get() == true) {
			Robot.intake.intakeMotor.set(RobotConstants.intakeGrabSpeed);
		} else {
			Robot.intake.intakeMotor.set(0);}
		}
		
		public void ejectBall() {
			// set intakeMotor to negative intakeEjectSpeed

			Robot.intake.intakeMotor.set(-RobotConstants.intakeGrabSpeed);

	}
	// else set intakeMotor to 0

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new teleopIntake());
	}

}
