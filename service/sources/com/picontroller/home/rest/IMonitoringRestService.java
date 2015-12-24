/**
 * 
 */
package com.picontroller.home.rest;

import com.picontroller.home.model.HealthCheckStatus;
import com.picontroller.home.service.IMonitoringService;

/**
 * @author dcharles
 *
 */
public interface IMonitoringRestService extends IMonitoringService {

	String ping();

	HealthCheckStatus healthCheck();
}
