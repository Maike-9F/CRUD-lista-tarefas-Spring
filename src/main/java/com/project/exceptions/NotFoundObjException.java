package com.project.exceptions;

public class NotFoundObjException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NotFoundObjException(String msg) {
		super(msg);
	}

}
