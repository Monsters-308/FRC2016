package org.usfirst.frc308.FRC2016;

public class RobotConstants {

	// Joystick 1 Buttons
	public static int platformShiftUpButton = 11;
	public static int platformShiftDownButton = 10;
	public static int chasisShiftUpButton = 9;
	public static int chasisShiftDownButton = 8;
	public static int chasisReverseDirectionButton = 5;

	// Joystick 2 Buttons
	public static int shootBallHigh = 1;
	public static int runIntakeMotor = 2;
	public static int ejectBall = 4;
	

	// Chassis Constants
	public static boolean direction = true;
	public static final boolean shooterDirection = true;
	public static final boolean intakeDirection = false;
	public static double Kp = 0.007;
	public static double Ki = 0.001;
	public static double Kd = 0.0;
	public static double iZone = 15.0;
	public static double maximumIZoneSpeed = 0.3;
	public static double rotateInertiaBias = 0.15;
	public static double gyroPIDErrorTolerance = 1.0; //in degrees
	public static double gyroPIDVelocityTolerance = 0.5; //in degrees/second

	// Shooter Constants
	public static double intakeGrabSpeed = 5000; // in rpm
	public static double intakeAdjustSpeed = 2000; // in rpm
	public static double intakeShooterSpeed = 0.0;
	public static double intakePIDKp = 0.0;
	public static double intakePIDKi = 0.000001;
	public static double intakePIDKd = 0.0;
	public static double intakePIDKf = 1023.0/12300.0; //1023/maximumspeed
	public static int intakePIDIZone = 0;
	public static double intakePIDRampRate = 0.0;
	public static double shooterSpeed = 10000.0;
	public static double shooterTolerance = 0.0; // units?
	public static double shooterPIDKp = 0.2;
	public static double shooterPIDKi = 0.0;
	public static double shooterPIDKd = 0.0;
	public static double shooterPIDKf = 1023.0/12300.0; //1023/maximumspeed
	public static int shooterPIDIZone = 0;
	public static double shooterPIDRampRate = 0.0;

	// Arm Constants
	public static double armLowHeight = 0.0;
	public static double armHighHeight = 0.0;
	public static double armPIDKp = 0.0;
	public static double armPIDKi = 0.0;
	public static double armPIDKd = 0.0;
	
	//Joysick Constants
	public static double deadZone = 0.1;
	

	//vision Constants
	public static double cameraFieldOfView = 49.0; //in degrees

}
