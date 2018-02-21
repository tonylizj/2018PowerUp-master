package org.usfirst.frc.team4001.robot;

/**
 * Used to store various constants used throughout the robot i.e speed settings, pid values
 *  @author Eric Fabroa
 * 
 */


public class NumberConstants {
	
	//**************************************************************************
    //*************************** PID VALUES (DRIVE) ***************************
    //**************************************************************************
	
	//Competition

	public static double pDrive 									 = 0.07;
	public static double iDrive 									 = 0.00;
	public static double dDrive 									 = 0.0;
	
	public static final double DRIVE_SCALE 								 = 0.5;
	
	
	//**************************************************************************
    //**************************** PID VALUES (GYRO) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pGyro 									 = 0.1;
	public static final double iGyro 									 = 0.00;
	public static final double dGyro 									 = 0.05;
	
	// ************************************************************************
	// **************************  ELEVATOR  **********************************
	// ************************************************************************
	
	//public static final double elevatorMaxVoltage  						 = 0.5;
	public static final double elevatorSpeed							 = 0.4;	
	public static final double extendSpeed								 = 0.5;
	public static final double climbSpeed 								 = 0.3;

	// ************************************************************************
	// **************************  INTAKE  ************************************
	// ************************************************************************
	
	public static final double rollInSpeed								= 1;
	public static final double rollOutSpeed								= -1;
	
}
