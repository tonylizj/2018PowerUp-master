package org.usfirst.frc.team4001.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4001.robot.commands.*;
import org.usfirst.frc.team4001.robot.commands.auto.DriveStraightGyro;
import org.usfirst.frc.team4001.robot.commands.auto.LeftAuto;
import org.usfirst.frc.team4001.robot.commands.auto.MiddleAuto;
import org.usfirst.frc.team4001.robot.commands.auto.RightAuto;
import org.usfirst.frc.team4001.robot.subsystems.DriveTrain4Talon;
import org.usfirst.frc.team4001.robot.subsystems.Elevator;
import org.usfirst.frc.team4001.robot.subsystems.ExampleSubsystem;
//import org.usfirst.frc.team4001.robot.subsystems.Intake;
import org.usfirst.frc.team4001.robot.subsystems.Intake;

import com.team4001.lib.util.PreferenceChanger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain4Talon drive; //TODO verify this is the correct drivetrain subsystem
	public static Elevator elevator;
	public static Intake intake;
	public static OI oi;
	private PreferenceChanger preference;


	Command autonomousCommand;
	SendableChooser<String> chooser;


	/**x
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		drive = new DriveTrain4Talon(); 
		elevator = new Elevator();
		intake = new Intake();
		oi = new OI();
		preference = new PreferenceChanger();
		chooser = new SendableChooser<String>();
		chooser.addDefault("Left Position", "Left");
		chooser.addObject("Middle Position", "Middle");
		chooser.addObject("Right Position", "Right");
				
		SmartDashboard.putData("Autonomous Position", chooser);
		SmartDashboard.putData("Zero Elevator",new ElevatorResetZero());
		SmartDashboard.putData("Push Forward", new ElevatorPushForward());
		SmartDashboard.putData("Push Back", new ElevatorPushBack());


		// chooser.addObject("My Auto", new MyAutoCommand());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new DriveStraightGyro(100);
		/*if(chooser.getSelected().equals("Left")){	
			autonomousCommand = new LeftAuto();
		}
		else if(chooser.getSelected().equals("Middle")){
			autonomousCommand = new MiddleAuto();
		}
		else{
			autonomousCommand = new RightAuto();
		}
		*/
		
		
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Average Distance", drive.getAverageDistance());
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Encoder Value", Robot.elevator.getEncPosition());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
