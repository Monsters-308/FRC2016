package org.usfirst.frc308.FRC2016.commands;

import org.usfirst.frc308.FRC2016.Robot;
import org.usfirst.frc308.FRC2016.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousApproachGoal extends CommandGroup {

	public AutonomousApproachGoal() {
		Robot.chasis.setRotatePID(0);
		addSequential(new AutonomousShift(true));
		addParallel(new AutonomousSetArm(-0.9, 2.0));
		addSequential(new AutonomousTimedDrive(0.85, 2.0));
		addParallel(new AutonomousSetArm(0.0, 2.0));
		
		addSequential(new AutonomousShift(false));
		addSequential(new AutonomousTrajectoryFollower());
		addParallel(new AutonomousRevUpMotor(RobotConstants.shooterSpeed));
		addSequential(new turnToTarget(false));
		addSequential(new AutonomousGoalDrive(0.4));
		addSequential(new turnToTarget(false));
		
		addSequential(new AutonomousShootBall());
	}

}
