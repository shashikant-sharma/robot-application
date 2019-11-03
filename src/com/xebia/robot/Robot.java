package com.xebia.robot;

import com.xebia.robot.impl.Settings;

public interface Robot  {
   
	public void onOff();
	
	public Settings getSettings();
}
