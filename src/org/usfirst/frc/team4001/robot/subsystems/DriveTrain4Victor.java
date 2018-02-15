package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Implementation of a basic 4 Victor motor {@link DriveTrain}
 * @author eric
 * @see DriveTrain
 */
public class DriveTrain4Victor extends DriveTrain {
	
	private Victor frontLeftMotor;
	private Victor frontRightMotor;
	private Victor rearLeftMotor;
	private Victor rearRightMotor;
	
	protected SpeedControllerGroup speedControllerLeft;
	protected SpeedControllerGroup speedControllerRight;
	
	public DriveTrain4Victor() {
		
		//Initialize motors
		frontLeftMotor = new Victor(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
		frontLeftMotor.setInverted(ElectricalConstants.DRIVETRAIN_FRONT_LEFT_REVERSE);
		
		frontRightMotor = new Victor(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
		frontRightMotor.setInverted(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT_REVERSE);
		
		//rearLeftMotor = new Victor(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
		//rearLeftMotor.setInverted(ElectricalConstants.DRIVETRAIN_REAR_LEFT_REVERSE);
		
		//rearRightMotor = new Victor(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
		//rearRightMotor.setInverted(ElectricalConstants.DRIVETRAIN_REAR_RIGHT_REVERSE);
		
		//initialize Drive Train

		//speedControllerLeft = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
		//speedControllerRight = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
		drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

	}
	

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}

	@Override
	public void runLeftDrive(double power) {
		frontLeftMotor.set(power);
	}
	

	@Override
	public void runRightDrive(double power) {

		frontRightMotor.set(power);
	}

}
