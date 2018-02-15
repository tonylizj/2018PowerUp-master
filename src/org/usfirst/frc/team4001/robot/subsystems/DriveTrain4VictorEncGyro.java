package org.usfirst.frc.team4001.robot.subsystems;

import com.team4001.lib.util.GyroDrive;
import com.team4001.lib.util.PIDController;

import org.usfirst.frc.team4001.robot.NumberConstants;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;


/**
 * 4 Victor motor drivetrain with encoders and gyro.  Includes pid controlled driveStraight method
 * @author eric
 *@see DriveTrain
 * *@see DriveTrain4Victor
 *@see DriveTrain4VictorEnc
 *@see com.team4001.lib.util.GyroDrive
 */
public class DriveTrain4VictorEncGyro extends DriveTrain4VictorEnc implements GyroDrive {

	//Gyro
	private ADXRS450_Gyro gyro;
		
	//PID controllers
	public PIDController drivePID;
	public PIDController gyroPID;
	
	
	public DriveTrain4VictorEncGyro() {
		super(); //initialize motors and encoders at parent class
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
	
	/**
	 * Using both PID controllers (drive & gyro), the drivetrain will move to
	 * target at given speed and angle
	 *
	 * @param setPoint
	 *            The set point in inches
	 * @param speed
	 *            The speed (0.0 to 1.0)
	 * @param setAngle
	 *            The set angle in degrees
	 * @param epsilon
	 *            How close robot should be to target to consider reached
	 */
	public void driveStraight(double setPoint, double speed, double setAngle, double epsilon) {
		double output = drivePID.calcPIDDrive(setPoint, getAverageDistance(), epsilon);
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);
		
		System.out.println("driveStraight output: " + output);
		System.out.println("driveStraight angle: " + angle);
		
		
		runLeftDrive(-(output + angle) * speed);
		runRightDrive(-(-output + angle) * speed);
	}

}
