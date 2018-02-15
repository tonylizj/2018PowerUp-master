package com.team4001.lib.util;


/**
 * Interface containing methods for a drivetrain with a gyro
 * @author eric
 *
 */
public interface GyroDrive {
	
	/**
	 * Initialize gyro object.  Constructor needs to call this.
	 */
	public void initGyro();
	
	/**
	 * Used to move robot without a drive PID controller at a given speed, while
	 * at the angle given.
	 *
	 * @param setAngle
	 *            The set angle in degrees
	 * @param speed
	 *            The speed (-1.0 - 1.0)
	 */
	public void driveAngle(double setAngle, double speed);
	
	
	
	/**
     * This method returns the current yaw(angle) of the gyro
     * @return the current angle of the gyro
     */
	public double getYaw();
	
	
	/**
	 * Reset the Gyro
	 */
	public void resetGyro();
	
	
	/**
	 * Using a PID controller, turns the robot to given angle with the given
	 * speed.
	 *
	 * @param setAngle
	 *            The set angle in degrees
	 * @param speed
	 *            The speed (0.0 - 1.0)
	 * @param epsilon
	 *            How close robot should be to target to consider reached
	 */
	public void turnDrive(double setAngle, double speed, double epsilon);
	
}
