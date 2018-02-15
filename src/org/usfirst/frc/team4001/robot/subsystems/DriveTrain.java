
package org.usfirst.frc.team4001.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Abstract class for DriveTrain subsystems enforcing basic drive train methods.
 */
@SuppressWarnings("deprecation")
public abstract class DriveTrain extends Subsystem {
	
	protected DifferentialDrive drive;

	/**
	 * Set the default command for a subsystem here.
	 * setDefaultCommand(new MySpecialCommand());
	 */
    public abstract void initDefaultCommand();
    
    /**
     * Basic split control arcade drive method
     * @param forward	The forward/back power amount (y-axis control)
     * @param turn		The left/right power amount (x-axis control)
     * @param scale		Scale factor to apply (must be > 0 and <= 1 )
     */
    public void arcadeDrive(double forward, double turn, double scale) {
    		if (scale < 0 || scale > 1) {
    			 throw new IllegalArgumentException("scale must be in range 0 <= scale <= 1");
    		}else {

    			this.drive.arcadeDrive(forward*scale, turn*scale);
    		}
    }
    
    
    /**
     * Turn off power to the drive train
     */
    public void hardStop() {
    		this.drive.arcadeDrive(0, 0);
    }
    
    
    /**
	 * Sends supplied power value to the left drive motors.
	 *
	 * @param power
	 *            Power value sent to motors (-1.0 to 1.0)
	 */
    public abstract void runLeftDrive(double power);
    
    
    /**
	 * Sends supplied power value to the right drive motor(s).
	 *
	 * @param power
	 *            Power value sent to motors (-1.0 to 1.0)
	 */
    public abstract void runRightDrive(double power);
    
    
    /**
     * 
     * @param leftPower
     * 			Power amount to apply to left motor(s) (-1.0 to 1.0)
     * @param rightPower
     * 			Power amount to apply to right motor(s) (-1.0 to 1.0)
     * @param scale
     * 			Scale factor to apply (must be > 0 and <= 1 )
     */
    public void tankDrive(double leftPower, double rightPower, double scale) {
    	
    		if (scale <= 0 || scale > 1) {
			 throw new IllegalArgumentException("scale must be in range 0 < scale <= 1");
		}else {
			runLeftDrive(leftPower*scale);
    			runRightDrive(rightPower*scale);
		}
    		
    }
    
    
}