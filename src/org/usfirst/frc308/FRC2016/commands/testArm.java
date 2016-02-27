package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class testArm extends Command{
	
	public testArm(){
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		Robot.arm.setupArmMotor();
		Robot.arm.setArmPosition(1.0);
	}

	@Override
	protected void execute() {
		Robot.arm.displayArmData();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
