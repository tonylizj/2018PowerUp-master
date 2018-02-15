package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.NumberConstants;

import com.team4001.lib.util.GyroDrive;
import com.team4001.lib.util.PIDController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * 4 Victor motor drive train with an ADXRS450 Gyro
 * @author Eric Fabroa
 *@see DriveTrain
 *@see DriveTrain4Victor
 *@see com.team4001.lib.util.GyroDrive
 */
public class DriveTrain4VictorGyro extends DriveTrain4Victor implements GyroDrive {
	
	//Gyro
	private ADXRS450_Gyro gyro;
		
	//PID controllers
	public PIDController drivePID;
	public PIDController gyroPID;
	
	public DriveTrain4VictorGyro() {
		super(); //initialize motors at parent class
		this.initGyro();
		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dDrive);
	}

	@Override
	public void initGyro() {
		//initialize gyro
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyro.reset();
		
	}

	@Override
	public void driveAngle(double setAngle, double speed) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), 1);

		runLeftDrive(speed + angle);
		runRightDrive(-speed + angle);

	}


	@Override
	public double getYaw() {
		return gyro.getAngle();
	}

	@Override
	public void resetGyro() {
		gyro.reset();

	}

	@Override
	public void turnDrive(double setAngle, double speed, double epsilon) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);

		runLeftDrive(-angle * speed);
		runRightDrive(-angle * speed);
	}

}
