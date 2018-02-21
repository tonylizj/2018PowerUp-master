package org.usfirst.frc.team4001.robot.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;
//import org.usfirst.frc.team4001.robot.commands.RollOutArms;
import org.usfirst.frc.team4001.robot.commands.RollOutArms;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAuto extends CommandGroup {

	private String gameData;
    public RightAuto() {
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.charAt(0) == 'R'){
    		System.out.println("Auto running for right side switch");
    		addSequential(new DriveStraightGyro(165.354));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(19.2913));
    		addSequential(new RollOutArms());
    	}
    	else if(gameData.charAt(1) == 'R'){
    		System.out.println("Auto running for right side scale");
    		addSequential(new DriveStraightGyro(325.1968));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(8.2677));    	
    	}
    	else if(gameData.charAt(0) == 'L'){
    		System.out.println("Auto running for left side switch");
    		addSequential(new DriveStraightGyro(225.70866));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(181.8901)); 
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(60.62994)); 
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(11.0236));
    		addSequential(new RollOutArms());
    	}
    	else if(gameData.charAt(1) == 'L'){
    		System.out.println("Auto running for left side scale");
    		addSequential(new DriveStraightGyro(225.9845));
    		addSequential(new TurnGyro(-90));
    		addSequential(new DriveStraightGyro(195.6696));
    		addSequential(new TurnGyro(90));
    		addSequential(new DriveStraightGyro(121.8683));
    		addSequential(new TurnGyro(90));
    		addSequential(new DriveStraightGyro(8.2677));
    		
    		
    		//Not sure what this is
//    		addSequential(new DriveStraightGyro(70));
//    		addSequential(new TurnGyro(-90));
//    		addSequential(new DriveStraightGyro(149));
//    		addSequential(new TurnGyro(90));
//    		addSequential(new DriveStraightGyro(262));
//    		addSequential(new TurnGyro(90));
//    		addSequential(new DriveStraightGyro(30));
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
