// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;
import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chasis extends Subsystem {

	boolean turning = true;

	// PID Stuff
	double setPoint = 0.0; // the point we are going to
	double IAccumulator = 0.0; // the sum of error over time
	double lastError = 0.0; // the previous error
	long lastTime = 0; // the previous time

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	// I'm in
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final CANTalon left1 = RobotMap.chasisleft1;
	private final CANTalon left2 = RobotMap.chasisleft2;
	private final CANTalon left3 = RobotMap.chasisleft3;
	private final CANTalon right1 = RobotMap.chasisright1;
	private final CANTalon right2 = RobotMap.chasisright2;
	private final CANTalon right3 = RobotMap.chasisright3;
	private final AnalogGyro gyro = RobotMap.chasisgyro;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final Solenoid shifter = RobotMap.pneumaticsshifter;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new teleopDrive());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void calibrateGyro() {
		// gyro.calibrate();
	}

	public void setupBasicDrive() {
		left1.changeControlMode(TalonControlMode.PercentVbus);
		left2.changeControlMode(TalonControlMode.Follower);
		left2.set(4);
		left3.changeControlMode(TalonControlMode.Follower);
		left3.set(4);
		right1.changeControlMode(TalonControlMode.PercentVbus);
		right2.changeControlMode(TalonControlMode.Follower);
		right2.set(1);
		right3.changeControlMode(TalonControlMode.Follower);
		right3.set(1);

		gyro.reset();
		setPoint = gyro.getAngle(); // make setpoint current angle
		IAccumulator = 0; // reset accumulator
	}

	public void shiftUp() {
		// Matteo
		// set shifter to up
		Robot.chasis.shifter.set(true);
	}

	public void shiftDown() {
		// Matthew
		// set shifter to down
		Robot.chasis.shifter.set(false);
	}

	/**
	 * sets up the PID for rotate command
	 */
	public void setRotatePID(double angleSetPoint) {
		gyro.reset(); // reset gyro so our angle is 0
		setPoint = angleSetPoint; // set our setpoint
		IAccumulator = 0; // reset accumulator
	}

	public boolean isOnTarget() {
		// if our error is within tolerance and our rotation speed is within our
		// tolerance
		if (Math.abs(setPoint - gyro.getAngle()) < RobotConstants.gyroPIDErrorTolerance
				&& Math.abs(gyro.getRate()) < RobotConstants.gyroPIDVelocityTolerance) {
			return true;
		}
		return false;
	}

	public void autonomousRotate() {
		SmartDashboard.putNumber("angle", gyro.getAngle());
		SmartDashboard.putNumber("rotation speed", gyro.getRate());
		double turn = 0.0;
		double error = gyro.getAngle() - setPoint;
		// makes sure error is between -180 and 180
		if (error < -180.0) {
			while (error < -180.0) {
				error += 360.0;
			}
		} else if (error > 180.0) {
			while (error > 180.0) {
				error -= 360.0;
			}
		}
		SmartDashboard.putNumber("error", error);
		if (Math.abs(error) < RobotConstants.iZone) { // if we're in the izone
			IAccumulator = IAccumulator + error; // sum up error
			if (RobotConstants.Kp * error + RobotConstants.Ki * IAccumulator > RobotConstants.maximumIZoneSpeed) {
				IAccumulator = (RobotConstants.maximumIZoneSpeed - RobotConstants.Kp * error) / RobotConstants.Ki;
			}
		} else {
			IAccumulator = 0;
		}
		if (error * lastError <= 0) { // if error changes signs (we crossed 0)
			IAccumulator = 0;
		}
		double derivative = (error - lastError) / ((System.currentTimeMillis() - lastTime) / 1000.0);
		turn = RobotConstants.Kp * error + RobotConstants.Ki * IAccumulator + RobotConstants.Kd * derivative;
		lastError = error;
		lastTime = System.currentTimeMillis();
		if (turn > 1.0) { // make sure turn isn't too high
			turn = 1.0;
		} else if (turn < -1.0) { // make sure turn isn't too low
			turn = -1.0;
		}
		left1.set(-turn);
		right1.set(turn);
	}

	public double deadZone(double input) {
		if (Math.abs(input) < RobotConstants.deadZone) {
			return 0.0;
		}
		return input;
	}

	public void basicDrive(double power, double turn) {
		SmartDashboard.putNumber("turn commanded", turn);
		SmartDashboard.putNumber("angle", gyro.getAngle());
		SmartDashboard.putNumber("rotation speed", gyro.getRate());
		if (turn == 0.0) { // driver isn't turning, keep the last angle
			double error = gyro.getAngle() - setPoint;
			SmartDashboard.putNumber("error", error);
			// make sure error is between -180.0 and 180.0
			if (error < -180.0) {
				while (error < -180.0) {
					error += 360.0;
				}
			} else if (error > 180.0) {
				while (error > 180.0) {
					error -= 360.0;
				}
			}
			if (turning == true) { // first time/initialize
				setPoint = gyro.getAngle() + RobotConstants.rotateInertiaBias * gyro.getRate(); // make
																								// setpoint
																								// current
																								// angle
				IAccumulator = 0; // reset accumulator
				turning = false; // we are no longer turning
			} else { // after initializing
				if (Math.abs(error) < RobotConstants.iZone) { // if we're in the
																// izone
					IAccumulator = IAccumulator + error; // sum up error
					if (RobotConstants.Kp * error
							+ RobotConstants.Ki * IAccumulator > RobotConstants.maximumIZoneSpeed) {
						IAccumulator = (RobotConstants.maximumIZoneSpeed - RobotConstants.Kp * error)
								/ RobotConstants.Ki;
					}
				} else {
					IAccumulator = 0;
				}
				if (error * lastError <= 0) { // if error changes signs (we
												// crossed 0)
					IAccumulator = 0;
				}
				double derivative = (error - lastError) / ((System.currentTimeMillis() - lastTime) / 1000.0);
				turn = RobotConstants.Kp * error + RobotConstants.Ki * IAccumulator + RobotConstants.Kd * derivative;
			}
			lastError = error;
			lastTime = System.currentTimeMillis();
			if (turn > 1.0) { // make sure turn isn't too high
				turn = 1.0;
			} else if (turn < -1.0) { // make sure turn isn't too low
				turn = -1.0;
			}
		} else if (turn != 0.0) { // a turn is being commanded
			turning = true;
		}
		left1.set((power - turn) / 2.0);
		right1.set((power + turn) / 2.0);
	}

}
