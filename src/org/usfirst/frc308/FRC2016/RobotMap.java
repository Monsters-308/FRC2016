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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chasisleft1;
    public static CANTalon chasisleft2;
    public static CANTalon chasisleft3;
    public static CANTalon chasisright1;
    public static CANTalon chasisright2;
    public static CANTalon chasisright3;
    public static AnalogGyro chasisgyro;
    public static CANTalon shootershootMotor1;
    public static CANTalon shooterintakeMotor;
    public static CANTalon shooterhoodMotor;
    public static CANTalon armarmMotor;
    public static Compressor pneumaticsCompressor;
    public static Solenoid pneumaticsshifter;
    public static Solenoid pneumaticsshooterLift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chasisleft1 = new CANTalon(4);
        LiveWindow.addActuator("Chasis", "left1", chasisleft1);
        
        chasisleft2 = new CANTalon(5);
        LiveWindow.addActuator("Chasis", "left2", chasisleft2);
        
        chasisleft3 = new CANTalon(6);
        LiveWindow.addActuator("Chasis", "left3", chasisleft3);
        
        chasisright1 = new CANTalon(1);
        LiveWindow.addActuator("Chasis", "right1", chasisright1);
        
        chasisright2 = new CANTalon(2);
        LiveWindow.addActuator("Chasis", "right2", chasisright2);
        
        chasisright3 = new CANTalon(3);
        LiveWindow.addActuator("Chasis", "right3", chasisright3);
        
        chasisgyro = new AnalogGyro(0);
        LiveWindow.addSensor("Chasis", "gyro", chasisgyro);
        chasisgyro.setSensitivity(0.007);
        shootershootMotor1 = new CANTalon(10);
        LiveWindow.addActuator("Shooter", "shootMotor1", shootershootMotor1);
        
        shooterintakeMotor = new CANTalon(12);
        LiveWindow.addActuator("Shooter", "intakeMotor", shooterintakeMotor);
        
        shooterhoodMotor = new CANTalon(13);
        LiveWindow.addActuator("Shooter", "hoodMotor", shooterhoodMotor);
        
        armarmMotor = new CANTalon(15);
        LiveWindow.addActuator("Arm", "armMotor", armarmMotor);
        
        pneumaticsCompressor = new Compressor(0);
        
        
        pneumaticsshifter = new Solenoid(0, 0);
        LiveWindow.addActuator("Pneumatics", "shifter", pneumaticsshifter);
        
        pneumaticsshooterLift = new Solenoid(0, 1);
        LiveWindow.addActuator("Pneumatics", "shooterLift", pneumaticsshooterLift);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
