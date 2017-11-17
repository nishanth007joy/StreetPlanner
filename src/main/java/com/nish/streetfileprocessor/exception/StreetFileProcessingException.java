package com.nish.streetfileprocessor.exception;
/**
 * 
 * @author nismj
 *
 */
public class StreetFileProcessingException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param message
	 */
	public StreetFileProcessingException(String message) {
		super(message);
	}
	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	public StreetFileProcessingException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
