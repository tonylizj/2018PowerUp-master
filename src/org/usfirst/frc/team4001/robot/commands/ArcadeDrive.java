package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.AutoSelector;
import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic arcade drive command.  Applies scale factor from Electrical Constants
 */
public class ArcadeDrive extends Command {
	
	double moveForward;
	double turn;

    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	moveForward = Robot.oi.game_controller.getLeftY();
    	turn = Robot.oi.game_controller.getRightX();
    	
    	Robot.drive.arcadeDrive(-1*moveForward, turn, 1);
    	//System.out.println("Boolean: " + Robot.elevator.getExtenderLimit());
    	System.out.println("Boolean: " + Robot.elevator.getElevatorLimit());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.hardStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
