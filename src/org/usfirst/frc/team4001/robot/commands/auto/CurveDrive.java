package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import com.team4001.lib.util.BezierCurve;
import com.team4001.lib.util.Point;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CurveDrive extends Command {
	
	Point p0 = new Point(0,0);
	Point p1 = new Point(56,120);
	Point p2 = new Point(56,165.354);
	Point p3 = new Point(-18.2,165.354);

	BezierCurve curve = new BezierCurve(p0, p1, p2, p3);
	
    public CurveDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(curve.findHypotenuse(0), 0.2, curve.findAngle(0), 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
