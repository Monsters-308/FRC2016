package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousRevUpMotor extends Command {

	double speedOfRev;	
	
	public AutonomousRevUpMotor(double revSpeed) {
		requires(Robot.shooter);
		speedOfRev = revSpeed;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shooter.setupShooter();
		Robot.shooter.setMotorSpeed(speedOfRev);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
