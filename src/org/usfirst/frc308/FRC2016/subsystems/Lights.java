package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.RobotMap;
import org.usfirst.frc308.FRC2016.commands.teleopLights;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {

	Relay topLights = RobotMap.toplights;
	Relay bottomLights = RobotMap.bottomlights;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new teleopLights());
	}

}
