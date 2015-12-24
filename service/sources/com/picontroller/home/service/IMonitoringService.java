package com.picontroller.home.service;

import com.picontroller.home.exception.HealthCheckException;
import com.picontroller.home.model.HealthCheckStatus;

/**
 * Monitoring services.
 * 
 * @author dcharles
 *
 */
public interface IMonitoringService {

	/**
	 * Check the system.
	 * 
	 * @return The system status.
	 */
	HealthCheckStatus healthCheck() throws HealthCheckException;
}
