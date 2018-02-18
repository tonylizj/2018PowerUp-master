package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.team4001.lib.util.AxisButton;
import com.team4001.lib.util.Gamepad;
import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	/**
	 * The primary game controller (driver controller).  Gamepad controller mappings based on Logitech F310 controller.
	 * @see Gamepad
	 */
	public Gamepad game_controller;
	public Gamepad secondary_controller;
	private JoystickButton extendUpButton;
	private JoystickButton elevatorUpButton;
	private JoystickButton extendDownButton;
	private JoystickButton elevatorDownButton;
	private JoystickButton extendHoldButton;

	private JoystickButton pushForwardButton;
	private AxisButton pushBackButton;
	private JoystickButton goToZone1;

	private JoystickButton rollInButton;
	private JoystickButton rollOutButton;
	private JoystickButton climbButton;
	
	// TODO declare primary controller buttons


	/**
	 * Instantiate controller objects and bind buttons to commands.
	 */
	public OI() {
		// instantiate game controllers
		game_controller = new Gamepad(ElectricalConstants.GAMECONTROLLER_PRIMARY_PORT);
		secondary_controller = new Gamepad(ElectricalConstants.GAMECONTROLLER_SECONDARY_PORT);
		
		//Primary controller
		elevatorUpButton = game_controller.getButtonY();
		elevatorUpButton.whileHeld(new ElevatorUp());

		elevatorDownButton = game_controller.getButtonB();
		elevatorDownButton.whileHeld(new ElevatorDown());
		
		extendHoldButton = game_controller.getRightShoulder();
		extendHoldButton.whileHeld(new ExtendHold());
		
		extendUpButton = game_controller.getButtonX();
		extendUpButton.whileHeld(new ExtendUp());
		
		extendDownButton = game_controller.getButtonA();
		extendDownButton.whileHeld(new ExtendDown());
		
		/*
		pushForwardButton = game_controller.getLeftShoulder();
		pushForwardButton.whileHeld(new ElevatorPushForward());
		*/
		
		pushBackButton = game_controller.getLeftTriggerClick();
		pushBackButton.whileHeld(new ElevatorPushBack());
		
		goToZone1 = game_controller.getLeftShoulder();
		goToZone1.whenPressed(new goToZone1());

		//secondary controller
		
		//rollInButton = secondary_controller.getButtonY();
		//rollInButton.whileHeld(new RollInArms());

		
		//rollOutButton = secondary_controller.getButtonB();
		//rollOutButton.whileHeld(new RollOutArms());
		
		//climbButton = secondary_controller.getButtonA();
		//climbButton.whileHeld(new ClimbUp());

		// TODO bind game_controller buttons to commands
	
	}
}
