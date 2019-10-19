package com.xebia.robot;

import com.xebia.robot.impl.DefaultSettings;

public interface Robot  {
   
	public void on();
	
	public void off();
	
	public DefaultSettings getSettings();
}
