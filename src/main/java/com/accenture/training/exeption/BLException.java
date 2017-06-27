package com.accenture.training.exeption;

import org.apache.log4j.Logger;

/**
 * This class manage all exceptions thrown in the business logic layer.
 * @author Cristian Camilo Isaza - sisaza92@gmail.com
 */
public class BLException extends Exception {
	
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	
	
	public BLException(String message) {
		super(message);
		log.error(message);
	}
	
	

}
