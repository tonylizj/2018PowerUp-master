package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team4001.lib.util.PIDController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain4Talon extends DriveTrain {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private WPI_TalonSRX upperLeftMotor;
	private WPI_TalonSRX upperRightMotor;
	private WPI_TalonSRX bottomLeftMotor;
	private WPI_TalonSRX bottomRightMotor;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	private ADXRS450_Gyro gyro;
	
	private SpeedControllerGroup leftMotors;
	private SpeedControllerGroup rightMotors;
	
	public PIDController drivePID;
	public PIDController gyroPID;
	
	public DriveTrain4Talon(){
		upperLeftMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
		upperRightMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
		bottomLeftMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
		bottomRightMotor = new WPI_TalonSRX(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
		
		gyro = new ADXRS450_Gyro();
		
		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dGyro);
		
		leftEncoder = new Encoder(6,7,false, EncodingType.k4X);
		
		rightEncoder = new Encoder(8,9,false, EncodingType.k4X);
		
		leftMotors = new SpeedControllerGroup(upperLeftMotor, bottomLeftMotor);
		rightMotors = new SpeedControllerGroup(upperRightMotor, bottomRightMotor);
		
		drive = new DifferentialDrive(leftMotors, rightMotors);
	} 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArcadeDrive());
    }

	@Override
	public void runLeftDrive(double power) {
		// TODO Auto-generated method stub
		leftMotors.set(power);
	}

	@Override
	public void runRightDrive(double power) {
		// TODO Auto-generated method stub
		rightMotors.set(power);
	}
	
	public double getAverageDistance(){
		return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
	}
	
	public double getYaw() {
		return gyro.getAngle();
	}
	
	public void driveStraight(double setPoint, double speed, double setAngle, double epsilon) {
		double output = drivePID.calcPIDDrive(setPoint, getAverageDistance(), epsilon);
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);
		
		runLeftDrive(-(output + angle) * speed);
		runRightDrive(-(-output + angle) * speed);
	}
}

