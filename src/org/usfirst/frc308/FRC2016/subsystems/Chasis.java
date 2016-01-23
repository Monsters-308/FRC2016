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

import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chasis extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

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

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new teleopDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setupMotors() {
		leftFront.changeControlMode(TalonControlMode.PercentVbus);
		rightFront.changeControlMode(TalonControlMode.PercentVbus);
		leftRear.changeControlMode(TalonControlMode.PercentVbus);
		rightRear.changeControlMode(TalonControlMode.PercentVbus);
	}

	public void moveRobot(double power, double turning) {
		leftFront.set((power + turning) / 2.0);
		rightFront.set((power - turning) / 2.0);
		leftRear.set((power + turning) / 2.0);
		rightRear.set((power - turning) / 2.0);
	}
}
