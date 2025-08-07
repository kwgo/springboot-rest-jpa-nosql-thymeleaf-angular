package com.kwgo.quiz.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Class for log4J2 wrap.
 * 
 */
public class Log {
	/**
	 * To return a logger from log management
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StackTraceElement ste = stack[Math.min(2, stack.length - 1)];
		return LogManager.getLogger(ste.getClassName());
	}
}
