package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.team4001.lib.util.EncodedDrive;

import edu.wpi.first.wpilibj.Encoder;


/**
 * 4 Victor motor drivetrain with encoders
 * @author eric
 * @see DriveTrain
 * @see DriveTrain4Victor
 * @see com.team4001.lib.util.EncodedDrive
 *
 */
public class DriveTrain4VictorEnc extends DriveTrain4Victor implements EncodedDrive {
	
	private Encoder leftDriveEncoder;
	private Encoder rightDriveEncoder;
	
	public DriveTrain4VictorEnc() {
		super();
		this.initEncoders();
	}
	
	@Override
	public void initEncoders() {
		//initialize encoders
		leftDriveEncoder = new Encoder(ElectricalConstants.LEFT_DRIVE_ENCODER_A,
				ElectricalConstants.LEFT_DRIVE_ENCODER_B, ElectricalConstants.leftDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);
		leftDriveEncoder.setReverseDirection(ElectricalConstants.leftDriveTrainEncoderReverse);
		leftDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);

		rightDriveEncoder = new Encoder(ElectricalConstants.RIGHT_DRIVE_ENCODER_A,
				ElectricalConstants.RIGHT_DRIVE_ENCODER_B, ElectricalConstants.rightDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);
		rightDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		rightDriveEncoder.setReverseDirection(ElectricalConstants.rightDriveTrainEncoderReverse);

	}

	@Override
	public double getAverageDistance() {
		return (getLeftEncoderDist() + getRightEncoderDist()) / 2;
	}

	@Override
	public double getLeftEncoderDist() {
		return leftDriveEncoder.getDistance();
	}

	@Override
	public double getLeftEncoderRate() {
		return leftDriveEncoder.getRate();
	}

	@Override
	public double getLeftEncoderRaw() {
		return leftDriveEncoder.getRaw();
	}

	@Override
	public double getRightEncoderDist() {
		return rightDriveEncoder.getDistance();
	}

	@Override
	public double getRightEncoderRate() {
		return rightDriveEncoder.getRate();
	}

	@Override
	public double getRightEncoderRaw() {
		return rightDriveEncoder.getRaw();
	}
	
	public double getAverageEncoderDist(){
		return (leftDriveEncoder.getDistance() + rightDriveEncoder.getDistance())/2;
	}

	@Override
	public void resetEncoders() {
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
	}

}
