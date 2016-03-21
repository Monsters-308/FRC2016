package org.usfirst.frc308.FRC2016;

public class RobotConstants {

	// Joystick 1 Buttons
	public static int platformShiftUpButton = 7;
	public static int platformShiftDownButton = 8;
	public static int chasisShiftUpButton = 10;
	public static int chasisShiftDownButton = 9;
	public static int chasisReverseDirectionButton = 3;
	public static int chasisBrakeButton = 1;

	// Joystick 2 Buttons
	public static int shootBallHigh = 1;
	public static int runIntakeMotor = 2;
	public static int ejectBall = 4;
	public static int gateRoll = 9;
	

	// Chassis Constants
	public static double gyroPIDOutput = 0;
	public static boolean direction = true;
	public static final boolean shooterDirection = true;
	public static final boolean intakeDirection = false;
	public static double Kp = 0.012;
	public static double Ki = 0.006;
	public static double Kd = 0.0;
	public static double iZone = 15.0;
	public static double maximumIZoneSpeed = 0.3;
	public static double rotateInertiaBias = 0.15;
	public static double gyroPIDErrorTolerance = 1.0; //in degrees
	public static double gyroPIDVelocityTolerance = 0.5; //in degrees/second
	public static double Kv = 1.0/90.0; // 1/maximum
	public static double Ka = 0.0;
	public static double Kp2 = 0.0;
	public static double Ki2 = 0.0;
	public static double Kd2 = 0.0;

	// Shooter Constants
	public static double intakeGrabSpeed = 1500; // in rpm
	public static double intakeAdjustSpeed = 3000; // in rpm
	public static double intakeShooterSpeed = 8200.0;
	public static double intakePIDKp = 0.12;
	public static double intakePIDKi = 0.0002;
	public static double intakePIDKd = 0.0;
	public static double intakePIDKf = 1023.0/6300.0; //1023/maximumspeed
	public static int intakePIDIZone = 500;
	public static double intakePIDRampRate = 0.0;
	public static double shooterSpeed = 17000.0;
	public static double shooterTolerance = 500.0; // units?
	public static double shooterPIDKp = 0.07;
	public static double shooterPIDKi = 0.00013;
	public static double shooterPIDKd = 0.0;
	public static double shooterPIDKf = 1023.0/27000.0; //1023/maximumspeed
	public static int shooterPIDIZone = 3000;
	public static double shooterPIDRampRate = 0.0;
	public static boolean reverseoptical = false;

	// Arm Constants
	public static double armLowHeight = 0.0;
	public static double armHighHeight = -3600.0;
	public static double armPIDKp = 1.0;
	public static double armPIDKi = 0.001;
	public static double armPIDKd = 0.0;
	public static double armPIDKf = 0; //1023/maximumspeed
	public static int armPIDIZone = 0;
	public static double armPIDRampRate = 0.0;
	public static double armMaxSpeed = 0.001;
	public static boolean calibrationMode = false;
	
	//Joysick Constants
	public static double deadZone = 0.1;
	

	//vision Constants
	public static double cameraFieldOfView = 15.0; //in degrees

	public static boolean introduceBall = false;
	
}
