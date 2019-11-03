package com.xebia.robot.enums;

public enum Light {
   RED,GREEN,OFF;
   
   public boolean is(Light state) {
	return this==state;
   }
}
