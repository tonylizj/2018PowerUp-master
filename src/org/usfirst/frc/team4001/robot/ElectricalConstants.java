package org.usfirst.frc.team4001.robot;


/**
 * ElectricalConstants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.  ALL VALUES MUST BE VERIFIED off the default base code.
 */
public class ElectricalConstants {
	         
		// ************************************************************************
		// **************************  GAME CONTROLLERS  **************************
		// ************************************************************************
		
		public static final int GAMECONTROLLER_PRIMARY_PORT					= 0;
		public static final int GAMECONTROLLER_SECONDARY_PORT				= 1;
		
	
		// ************************************************************************
		// **************************  DRIVETRAIN  ********************************
		// ************************************************************************
		// TODO set motor ports

		
		public static final int DRIVETRAIN_FRONT_LEFT 						= 4;  // SET THIS
		public static final int DRIVETRAIN_FRONT_RIGHT 						= 2;  // SET THIS
		public static final int DRIVETRAIN_REAR_LEFT						= 3;  // SET THIS
		public static final int DRIVETRAIN_REAR_RIGHT 						= 1;  // SET THIS

		

		// Inverse state of drivetrain motors
		// TODO verify motor reverse settings
		public static final boolean DRIVETRAIN_FRONT_LEFT_REVERSE				= false;	// CHECK
		public static final boolean DRIVETRAIN_FRONT_RIGHT_REVERSE		 		= false;		// CHECK
		public static final boolean DRIVETRAIN_REAR_LEFT_REVERSE			 	= false;	// CHECK
		public static final boolean DRIVETRAIN_REAR_RIGHT_REVERSE			 	= false;		// CHECK
		
		
		//this needs to be set accordingly for distance calculations
		// TODO verify specifications for encoder calculations
		public static final int driveWheelRadius		 			= 3;//wheel radius in inches
		public static final int drivePulsePerRotation 				= 1024; //encoder pulse per rotation
		public static final double driveGearRatio 					= 10.71/1; //ratio between wheel and encoder
		public static final double driveEncoderPulsePerRot 			= drivePulsePerRotation*driveGearRatio; //pulse per rotation * gear ratio
		public static final double driveEncoderDistPerTick 			=(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
		public static final boolean leftDriveTrainEncoderReverse 	= true;
		public static final boolean rightDriveTrainEncoderReverse 	= false;
		
		//***************************************************************************
		//****************************** DRIVE ENCODERS *****************************
		//***************************************************************************
		
		public static final int LEFT_DRIVE_ENCODER_A                            = 6; 		//SET
		public static final int LEFT_DRIVE_ENCODER_B                            = 7;		//SET
		
		public static final int RIGHT_DRIVE_ENCODER_A                           = 8;		//SET
		public static final int RIGHT_DRIVE_ENCODER_B                           = 9;		//SET

		
		//***************************************************************************
		//****************************** INTAKE *************************************
		//***************************************************************************
		
		public static final int INTAKE_LEFT_ARM_MOTOR				= 15;   //SET
		public static final int INTAKE_RIGHT_ARM_MOTOR				= 14;   //SET
		
		public static final int INTAKE_LIMIT						= 0;  	
		
		// ************************************************************************
		// **************************  ELEVATOR  **********************************
		// ************************************************************************
		
		public static final int ELEVATOR_MOTOR                           		= 62;	
		public static final int PUSH_MOTOR										= 0;
		public static final int EXTEND_MOTOR									= 5;
		public static final int CLIMB_MOTOR1									= 13;
		public static final int CLIMB_MOTOR2									= 12;
		
		public static final int CUBE_LIFT_LIMIT									= 3;
		//public static final int PUSHER_FRONT_LIMIT								= -1;
		//public static final int PUSHER_BACK_LIMIT								= -1;
		public static final int EXTEND_LIMIT									= 2;
		
		
}

