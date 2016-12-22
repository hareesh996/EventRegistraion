package com.mindtree.evtmanagement.exception;

import com.mindtree.evtmanagement.utils.Utils;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public SystemException(Exception e,String...message) {
		super(e);
		this.message = Utils.concat(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
