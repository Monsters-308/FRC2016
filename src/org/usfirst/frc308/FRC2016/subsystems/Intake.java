package org.usfirst.frc308.FRC2016.subsystems;

import org.usfirst.frc308.FRC2016.commands.teleopIntake;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new teleopIntake());
	}

}
