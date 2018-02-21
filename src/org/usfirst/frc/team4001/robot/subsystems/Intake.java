package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Intake extends Subsystem {

    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;
        
    private DigitalInput cubeIn;
  
    public Intake() {
    	leftArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_LEFT_ARM_MOTOR);
    	rightArm = new WPI_TalonSRX(ElectricalConstants.INTAKE_RIGHT_ARM_MOTOR);
    	
    	cubeIn = new DigitalInput(ElectricalConstants.INTAKE_LIMIT);
    }
    
  
    public void armsRollIn()
    {
    	leftArm.set(-NumberConstants.rollInSpeed);
    	rightArm.set(NumberConstants.rollInSpeed);
    }
  
    public void armsRollOut() 
    {
    	leftArm.set(-NumberConstants.rollOutSpeed);
    	rightArm.set(NumberConstants.rollOutSpeed);
    }

    public void leftArmRollIn()
    {
    	leftArm.set(NumberConstants.rollInSpeed);
    }
   

    public void rightArmRollIn()
    {
    	rightArm.set(NumberConstants.rollInSpeed);
    }

    
    public void hardStopRoll() {
    	leftArm.set(0);
    	rightArm.set(0);
    }

    public boolean getIntakeLimit() {
    	return cubeIn.get();
    }

    public void initDefaultCommand() {
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        
}



