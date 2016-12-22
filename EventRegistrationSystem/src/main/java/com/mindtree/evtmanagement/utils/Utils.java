package com.mindtree.evtmanagement.utils;

public class Utils {

	public static String concat(String...message){
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < message.length; i++) {
			output.append(message[i]);
		}
		return output.toString();
	}
	
	
}
