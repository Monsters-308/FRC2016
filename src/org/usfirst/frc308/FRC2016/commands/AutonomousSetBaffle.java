package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSetBaffle extends Command {
	
	boolean State;

	public AutonomousSetBaffle(boolean state) {
		requires(Robot.shooter);
		State = state;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shooter.setBaffle(State);
		
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
