/**
 * 
 */
package com.picontroller.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picontroller.home.model.HealthCheckStatus;

/**
 * @author dcharles
 *
 */
@Service("monitoringService")
public class MonitoringService implements IMonitoringService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISIMCardService simCardService;
	
	@Override
	public HealthCheckStatus healthCheck() {
		log.debug("HealthCheck called.");
		final HealthCheckStatus status = new HealthCheckStatus();
		simCardService.sendSMS("+33671285988", "Application is " + status);
		return status;
	}

}