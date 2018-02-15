package com.team4001.lib.util;

import org.usfirst.frc.team4001.robot.NumberConstants;

import edu.wpi.first.wpilibj.Preferences;

public class PreferenceChanger {
	
	private Preferences prefs;
	
	public PreferenceChanger(){
		
		prefs = Preferences.getInstance();
		
		NumberConstants.pDrive = prefs.getDouble("p Drive", 0.10);
		NumberConstants.iDrive = prefs.getDouble("i Drive", 0.0);
		NumberConstants.dDrive = prefs.getDouble("d Drive", 0.03);
	}

}
