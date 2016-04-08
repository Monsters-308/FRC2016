package org.usfirst.frc308.FRC2016.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc308.FRC2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class AutonomousTrajectoryFollower extends Command {

	Timer t;
	EncoderFollower left;
	EncoderFollower right;

	public AutonomousTrajectoryFollower() {
		requires(Robot.chasis);
	}

	@Override
	protected void initialize() {
		Waypoint[] points = new Waypoint[] { new Waypoint(0, 0, 0), new Waypoint(20, 20, 1.3) };

		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_LOW, 0.05, 8.0, 2.0, 60.0);
		Trajectory trajectory = Pathfinder.generate(points, config);

		double wheelbase_width = 2.125;

		// Create the Modifier Object
		TankModifier modifier = new TankModifier(trajectory);

		// Generate the Left and Right trajectories using the original
		// trajectory
		// as the center
		modifier.modify(wheelbase_width);

		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getRightTrajectory());

		left.configureEncoder(Robot.chasis.getLeftEncoderPosition(), 1000, 7.5 / 12.0);
		right.configureEncoder(-Robot.chasis.getRightEncoderPosition(), 1000, 7.5 / 12.0);

		left.configurePIDVA(0.1, 0.0, 0.0, 1 / 9.0, 0);
		right.configurePIDVA(0.1, 0.0, 0.0, 1 / 9.0, 0);
		Robot.chasis.setRotatePID(0);
		t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				double l = left.calculate(Robot.chasis.getLeftEncoderPosition());
				double r = right.calculate(-Robot.chasis.getRightEncoderPosition());
				double desired_heading = Pathfinder.r2d(left.getHeading());
				Robot.chasis.setSetpoint(desired_heading / 4.0);
				Robot.chasis.setDrive(l, r);
				SmartDashboard.putNumber("left heading", Pathfinder.r2d(left.getHeading()));
			}
		}, 0, 50);
	}

	@Override
	protected void execute() {
		Robot.chasis.displayChasisData();
	}

	@Override
	protected boolean isFinished() {
		if (left.isFinished() || right.isFinished()) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		t.cancel();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
