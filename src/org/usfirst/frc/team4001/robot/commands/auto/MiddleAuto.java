package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.commands.RollOutArms;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleAuto extends CommandGroup {

	private String gameData;
	
    public MiddleAuto() {
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.charAt(0) == 'L'){
    		System.out.println("The auto running is for the left side switch");
    		addSequential(new DriveStraightGyro(66));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(83));
    		addSequential(new TurnGyro(90));
    		addSequential(new DriveStraightGyro(80));
    		addSequential(new RollOutArms());
    	}
    	else{
    		System.out.println("The auto running is for the right side switch");
    		addSequential(new DriveStraightGyro(118.5966));
    		addSequential(new RollOutArms());
    	}
   
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
