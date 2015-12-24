/**
 * 
 */
package com.picontroller.home.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dcharles
 *
 */
public class HealthCheckException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public HealthCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		log.error(message, cause);
	}

}
