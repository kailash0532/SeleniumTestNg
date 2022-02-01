package com.test.tests;

import org.apache.logging.log4j.*;


public class TestLogger {
	private static final Logger LOGGER = LogManager.getLogger(TestLogger.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LOGGER.debug("Hello this is a debug message");  
		
		LOGGER.info("Hello this is a info message");  
		
		LOGGER.fatal("Hello this is a fatal");  
	}

}
