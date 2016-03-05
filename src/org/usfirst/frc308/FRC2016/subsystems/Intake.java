package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;
import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.teleopIntake;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem {
	private final CANTalon intakeMotor = RobotMap.intakeMotor;
	private final AnalogInput intakeOpticalSensor = RobotMap.intakeopticalsensor;

	public void setupIntake() {
		intakeMotor.changeControlMode(TalonControlMode.Speed);
		intakeMotor.setProfile(0);
		intakeMotor.setPID(RobotConstants.intakePIDKp, RobotConstants.intakePIDKi, RobotConstants.intakePIDKd,
				RobotConstants.intakePIDKf, RobotConstants.intakePIDIZone, RobotConstants.intakePIDRampRate, 0);
	}

	public void displayOpticalSensorData() {
		SmartDashboard.putNumber("optical sensor", intakeOpticalSensor.getAverageVoltage());
		SmartDashboard.putNumber("intake power", intakeMotor.getOutputVoltage());
		SmartDashboard.putNumber("intake speed", intakeMotor.getEncVelocity());
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
	 * runs the intake motor
	 */
	public void runIntakeMotor() {
		// if highOpticalSensor is false
		// set intakeMotor to constant intakeGrabSpeed
			Robot.intake.intakeMotor.set(RobotConstants.intakeGrabSpeed);
	}

	public void ejectBall() {
		// set intakeMotor to negative intakeEjectSpeed

		Robot.intake.intakeMotor.set(-RobotConstants.intakeGrabSpeed);

	}

	public void setIntake(double intakePower) {
		intakeMotor.set(intakePower);
	}

	public boolean getOpticalSensor() {
		return intakeOpticalSensor.getAverageVoltage() <= 2.0;
	}

	// else set intakeMotor to 0

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new teleopIntake());
	}

}
