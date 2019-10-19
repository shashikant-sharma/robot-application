package com.xebia.robot.exception;

public class BatteryLowException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BatteryLowException(String message) {
        super(message);
    }

}