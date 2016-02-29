// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc308.FRC2016;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc308.FRC2016.commands.*;
import org.usfirst.frc308.FRC2016.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	Preferences prefs;
	CameraServer server;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Chasis chasis;
	public static Shooter shooter;
	public static Arm arm;
	public static Vision vision;
	public static Pneumatics pneumatics;
	public static Intake intake;
	public static Lights lights;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		chasis = new Chasis();
		shooter = new Shooter();
		arm = new Arm();
		vision = new Vision();
		pneumatics = new Pneumatics();
		intake = new Intake();
		lights = new Lights();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		autonomousCommand = new AutonomousCommand();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		server = CameraServer.getInstance();
        server.setQuality(30);
        server.startAutomaticCapture("cam0");
		
		SmartDashboard.putData("Rotate PID Test", new AutonomousRotate(45.0));
		SmartDashboard.putData("Rotate to Target", new turnToTarget());
		SmartDashboard.putData("Set Arm", new testArm());
		SmartDashboard.putData("test shooter", new testShooter());
		SmartDashboard.putData("Calibrate Gyro", new calibrateGyro());
		prefs = Preferences.getInstance();
		prefs.putDouble("chasis kp", RobotConstants.Kp);
		prefs.putDouble("chasis ki", RobotConstants.Ki);
		prefs.putDouble("chasis kd", RobotConstants.Kd);
		prefs.putDouble("chasis kp2", RobotConstants.Kp2);
		prefs.putDouble("chasis ki2", RobotConstants.Ki2);
		prefs.putDouble("chasis kd2", RobotConstants.Kd2);
		prefs.putDouble("chasis kv", RobotConstants.Kv);
		prefs.putDouble("chasis ka", RobotConstants.Ka);
		prefs.putDouble("intake kp", RobotConstants.intakePIDKp);
		prefs.putDouble("intake ki", RobotConstants.intakePIDKi);
		prefs.putDouble("intake kd", RobotConstants.intakePIDKd);
		prefs.putDouble("intake kf", RobotConstants.intakePIDKf);
		prefs.putDouble("shooter kp", RobotConstants.shooterPIDKp);
		prefs.putDouble("shooter ki", RobotConstants.shooterPIDKi);
		prefs.putDouble("shooter kd", RobotConstants.shooterPIDKd);
		prefs.putDouble("shooter kf", RobotConstants.shooterPIDKf);
		prefs.putDouble("arm kp", RobotConstants.armPIDKp);
		prefs.putDouble("arm ki", RobotConstants.armPIDKi);
		prefs.putDouble("arm kd", RobotConstants.armPIDKd);
		prefs.putDouble("arm kf", RobotConstants.armPIDKf);
		prefs.putDouble("arm low height", RobotConstants.armLowHeight);
		prefs.putDouble("arm high height", RobotConstants.armHighHeight);
		prefs.putDouble("camera field of view", RobotConstants.cameraFieldOfView);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		RobotConstants.Kp = prefs.getDouble("chasis kp", RobotConstants.Kp);
		RobotConstants.Ki = prefs.getDouble("chasis ki", RobotConstants.Ki);
		RobotConstants.Kd = prefs.getDouble("chasis kd", RobotConstants.Kd);
		RobotConstants.Kp2 = prefs.getDouble("chasis kp2", RobotConstants.Kp2);
		RobotConstants.Ki2 = prefs.getDouble("chasis ki2", RobotConstants.Ki2);
		RobotConstants.Kd2 = prefs.getDouble("chasis kd2", RobotConstants.Kd2);
		RobotConstants.Kv = prefs.getDouble("chasis kv", RobotConstants.Kv);
		RobotConstants.Ka = prefs.getDouble("chasis ka", RobotConstants.Ka);
		RobotConstants.intakePIDKp = prefs.getDouble("intake kp", RobotConstants.intakePIDKp);
		RobotConstants.intakePIDKi = prefs.getDouble("intake ki", RobotConstants.intakePIDKi);
		RobotConstants.intakePIDKd = prefs.getDouble("intake kd", RobotConstants.intakePIDKd);
		RobotConstants.intakePIDKf = prefs.getDouble("intake kf", RobotConstants.intakePIDKf);
		RobotConstants.shooterPIDKp = prefs.getDouble("shooter kp", RobotConstants.shooterPIDKp);
		RobotConstants.shooterPIDKi = prefs.getDouble("shooter ki", RobotConstants.shooterPIDKi);
		RobotConstants.shooterPIDKd = prefs.getDouble("shooter kd", RobotConstants.shooterPIDKd);
		RobotConstants.shooterPIDKf = prefs.getDouble("shooter kf", RobotConstants.shooterPIDKf);
		RobotConstants.armPIDKp = prefs.getDouble("arm kp", RobotConstants.armPIDKp);
		RobotConstants.armPIDKi = prefs.getDouble("arm ki", RobotConstants.armPIDKi);
		RobotConstants.armPIDKd = prefs.getDouble("arm kd", RobotConstants.armPIDKd);
		RobotConstants.armPIDKf = prefs.getDouble("arm kf", RobotConstants.armPIDKf);
		RobotConstants.armLowHeight = prefs.getDouble("arm low height", RobotConstants.armLowHeight);
		RobotConstants.armHighHeight = prefs.getDouble("arm high height", RobotConstants.armHighHeight);
		RobotConstants.cameraFieldOfView = prefs.getDouble("camera field of view", RobotConstants.cameraFieldOfView);
		chasis.setGyroPIDConstants();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
