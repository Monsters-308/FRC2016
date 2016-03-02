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

import org.usfirst.frc308.FRC2016.RobotConstants;
import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final CANTalon armMotor = RobotMap.armarmMotor;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new telopArm());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setupArmMotor() {
		armMotor.changeControlMode(TalonControlMode.Position);
		armMotor.setProfile(0);
		armMotor.setPID(RobotConstants.armPIDKp, RobotConstants.armPIDKi, RobotConstants.armPIDKd,
				RobotConstants.armPIDKf, RobotConstants.armPIDIZone, RobotConstants.armPIDRampRate, 0);
		armMotor.setEncPosition(3600);
		armMotor.set(0);
		armMotor.reverseOutput(true);
		armMotor.reverseSensor(true);
	}

	public void displayArmData(){
		SmartDashboard.putNumber("arm height", armMotor.getEncPosition());
		SmartDashboard.putNumber("arm error", armMotor.getError());
		SmartDashboard.putNumber("arm setpoint", armMotor.getSetpoint());
		SmartDashboard.putNumber("arm power", armMotor.getOutputVoltage());
	}
	
	public void setCalibrationMode(){
		armMotor.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	public void setPIDMode(){
		armMotor.changeControlMode(TalonControlMode.Position);
	}
	
	public void setArm(double power){
		armMotor.set(power);
	}
	
	/**
	 * Sets arm position based on height
	 * 
	 * @param height
	 *            The height of the arm, from -1.0 to 1.0
	 */
	public void setArmPosition(double height) {
		height = height + 1.0; // translate height from (-1 to 1) to (0 to 2)
		height = height / 2.0; // translate height from (0 to 2) to (0 to 1)
		height = height * (RobotConstants.armHighHeight - RobotConstants.armLowHeight);
		// translate height from (0 to 1) to (0 to (high-low))
		height = height + RobotConstants.armLowHeight; // translate from
														// (0 to (high-low)) to
														// (low to high)
		armMotor.set(height);
	}
}
