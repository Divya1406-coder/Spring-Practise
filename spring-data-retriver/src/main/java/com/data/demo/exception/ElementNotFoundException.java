package com.data.demo.exception;

public class ElementNotFoundException extends Exception {
	private static String msg = "No such Element Found!";
	
	public ElementNotFoundException() {
		super(msg);
	}
}
