package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import com.github.adambots.stronghold2016.drive.Drive;

public class Left {
	static int stage = 0;

	public static void goLeft() {
		if (Actuators.getLeftDriveMotor().getError() < 0.0001) {

			if (stage == 0) {
				Drive.driveWithPID(-20, 20);
				stage++;
			}
			if (stage == 1) {
				Drive.driveWithPID(72, 72);
				stage++;
			}
			if (stage == 2) {
				Drive.driveWithPID(20, -20);
				stage++;
			}
			if (stage == 3) {
				Drive.driveWithPID(120, 120);
			}

		}

	}
}
