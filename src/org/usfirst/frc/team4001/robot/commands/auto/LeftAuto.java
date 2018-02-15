package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAuto extends CommandGroup {

	private String gameData;
	
    public LeftAuto() {   
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println(gameData);
    	
    	if(gameData.charAt(0) == 'L'){
    		System.out.println("spooky ghosts");
    	}
    	else if(gameData.charAt(1) == 'L'){
    		System.out.println("Auto running for left side scale");
    	}
    	else if(gameData.charAt(0) == 'R'){
    		System.out.println("beware of the code ghosts");
    	}
    	else if(gameData.charAt(1) == 'R'){
    		System.out.println("Auto running for right side scale");
    	}
    	else{
    		System.out.println("Auto running to move forward");
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
