package org.usfirst.frc308.FRC2016;

public class RobotConstants {

	// Joystick 1 Buttons
	public static int platformShiftUpButton = 1;
	public static int platformShiftDownButton = 1;
	public static int chasisShiftUpButton = 1;
	public static int chasisShiftDownButton = 1;

	// Joystick 2 Buttons
	public static int shootBallHigh = 1;
	public static int runIntakeMotor = 2;
	public static int ejectBall = 4;
	

	// Chassis Constants
	public static double Kp = 0.005;
	public static double Ki = 0.0;
	public static double Kd = 0.0;
	public static double iZone = 10.0;
	public static double gyroPIDErrorTolerance = 1.0; //in degrees
	public static double gyroPIDVelocityTolerance = 0.5; //in degrees/second

	// Shooter Constants
	public static double intakeGrabSpeed = 0.0; // range -1 to 1
	public static double intakeAdjustSpeed = 0.2;
	public static double intakeShooterSpeed = 0.0;
	public static double shooterSpeed = 1.0;
	public static double shooterTolerance = 0.0; // units?
	public static double intakeEjectSpeed = 0.0;

	// Arm Constants
	public static double armLowHeight = 0.0;
	public static double armHighHeight = 0.0;
	public static double armPIDKp = 0.0;
	public static double armPIDKi = 0.0;
	public static double armPIDKd = 0.0;
	
	//Joysick Constants
	public static double deadZone = 0.1;
	

	

}
