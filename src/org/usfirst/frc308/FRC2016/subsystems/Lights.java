package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.teleopLights;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {

	DigitalOutput topLights = RobotMap.toplights;
	DigitalOutput topLights2 = RobotMap.toplights2;
	DigitalOutput bottomLights = RobotMap.bottomlights;
	DigitalOutput bottomLights2 = RobotMap.bottomlights2;
	
	public void setTop(boolean red, boolean green) {
		topLights.set(!red);
		topLights2.set(!green);
	}

	public void setBottom(boolean red, boolean blue) {
		bottomLights.set(!red);
		bottomLights2.set(!blue);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new teleopLights());
	}

}
