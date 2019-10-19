package com.xebia.robot.enums;

public enum State {
   ON,OFF,WALKING;
   
   public boolean is(State state) {
	return this==state;
   }
}
