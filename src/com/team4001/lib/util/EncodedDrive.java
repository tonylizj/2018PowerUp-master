package com.team4001.lib.util;


/**
 * Interface containing encoder methods for drivetrain
 * @author eric
 *
 */
public interface EncodedDrive {
	
	
	/**
	 * Initialize the encoder objects.  This needs to be called from the DriveTrain constructor.
	 */
	public void initEncoders();
	
	
	/**
	 * Gets the average distance between both encoders.
	 *
	 * @return Returns the average distance
	 */
	public double getAverageDistance();
	

	/**
	* This function returns the distance traveled from the left encoder in
	* inches.
	*
	* @return Returns distance traveled by encoder in inches
	*/
	public double getLeftEncoderDist();
	
	/**
	 * This function returns the rate the left encoder is moving at in
	 * inches/sec.
	 *
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getLeftEncoderRate();
	
	
	/**
	 * This function returns the raw value from the left encoder.
	 *
	 * @return Returns raw value from encoder
	 */
	public double getLeftEncoderRaw();
	
	
	/**
	 * This function returns the distance traveled from the right encoder in
	 * inches.
	 *
	 * @return Returns distance traveled by encoder in inches
	 */
	public double getRightEncoderDist();
	
	
	/**
	 * This function returns the rate the right encoder is moving at in
	 * inches/sec.
	 *
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getRightEncoderRate();

	/**
	 * This function returns the raw value from the right encoder.
	 *
	 * @return Returns raw value from encoder
	 */
	public double getRightEncoderRaw();
	
	
	/**
	 * Resets both left and right encoders.
	 */
	public void resetEncoders();
	
	

	

}
