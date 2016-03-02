package org.usfirst.frc308.FRC2016;

public class RobotConstants {

	// Joystick 1 Buttons
	public static int platformShiftUpButton = 6;
	public static int platformShiftDownButton = 7;
	public static int chasisShiftUpButton = 9;
	public static int chasisShiftDownButton = 8;
	public static int chasisReverseDirectionButton = 5;

	// Joystick 2 Buttons
	public static int shootBallHigh = 1;
	public static int runIntakeMotor = 2;
	public static int ejectBall = 4;
	

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
	public static double intakeGrabSpeed = 3000; // in rpm
	public static double intakeAdjustSpeed = 3000; // in rpm
	public static double intakeShooterSpeed = 6300.0;
	public static double intakePIDKp = 0.15;
	public static double intakePIDKi = 0.0002;
	public static double intakePIDKd = 0.0;
	public static double intakePIDKf = 1023.0/6300.0; //1023/maximumspeed
	public static int intakePIDIZone = 1000;
	public static double intakePIDRampRate = 0.0;
	public static double shooterSpeed = 9200.0;
	public static double shooterTolerance = 50.0; // units?
	public static double shooterPIDKp = 0.2;
	public static double shooterPIDKi = 0.0004;
	public static double shooterPIDKd = 0.0;
	public static double shooterPIDKf = 1023.0/9000.0; //1023/maximumspeed
	public static int shooterPIDIZone = 1000;
	public static double shooterPIDRampRate = 0.0;

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
	public static double cameraFieldOfView = 64.0; //in degrees

	public static boolean introduceBall = false;
	
}
