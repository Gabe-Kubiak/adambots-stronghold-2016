package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Sensors;
import org.usfirst.frc.team245.robot.Actuators;
import com.github.adambots.stronghold2016.arm.Arm;
import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_Porticullis extends Barrier {
	static boolean raisePosition = false;
	static boolean crossedPosition = false;

	public static boolean Porticullis(double raise) {
		boolean raisePosition = false;
		// double tolerance = 0; // gyro stuuf
		double armIncrementalSpeed = .5;
		double distance = 24;// to gate type thingamabob
		double distance2 = 60;// inches from midpoint of defense when arm raised
		if (Sensors.getArmMaxLimitSwitch().get() == true) {
			Actuators.getArmAngleMotor().set(0);
		}
		if (raisePosition == false) {
			Drive.driveWithPID(distance, distance);
		}
		if (Actuators.getLeftDriveMotor().getError() <= 20) {
			raisePosition = true;
			if (Sensors.getStringPotArmAngle() < raise) {
				Arm.moveArm(armIncrementalSpeed);// Arm speed may change
			} else {
				Drive.driveWithPID(distance2, distance2);
				if (Actuators.getLeftDriveMotor().getError() <= 20) {
					crossedPosition = true;
					return true;
				}
			}

		}
		return false;

		// EXPERIMENTAL GYRO DEFENSE CROSSING PLZ IGNORE
		// if (position == true)
		// if (Sensors.getStringPotArmAngle() < raise) {
		// Arm.moveArm(armIncrement);// Arm speed may change
		// } else {
		// Drive.driveWithPID(distance2,distance2);
		// // needs positioning
		// if (Sensors.getRobotGyro().getAngle() > -tolerance) {
		//
		// }
		// }
		//
		// if (Sensors.getRobotGyro().getAngle() > -tolerance &&
		// Sensors.getRobotGyro().getAngle() < tolerance) {
		// counter++;
		// if (counter >= clearanceTime) {
		// Drive.drive(speed);
		// }
		// if (counter >= clearanceTime && Sensors.getRobotGyro().getAngle()
		// > -tolerance
		// && Sensors.getRobotGyro().getAngle() < tolerance) {
		// if (Sensors.getArmMinLimitSwitch().get() == false) {
		// Arm.moveArm(-armIncrement);// might need to change increment
		// }
		// }
		// }

	}
}
