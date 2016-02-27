package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousShootBall extends CommandGroup {

	public AutonomousShootBall() {
		//set baffle - parallel
		addSequential(new AutonomousSetBaffle(true));
		
		//rev up motor - sequential
		addSequential(new AutonomousRevUpMotor(RobotConstants.shooterSpeed));
		
		//run intake
		addSequential(new AutonomousIntroduceBall(RobotConstants.intakeShooterSpeed));
		
		//stop
		addSequential(new AutonomousSetBaffle(false));
		addSequential(new AutonomousRevUpMotor(0));
		addSequential(new AutonomousSetIntake(0));
		
		
		}

}
