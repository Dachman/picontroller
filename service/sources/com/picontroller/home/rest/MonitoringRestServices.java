package com.picontroller.home.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picontroller.home.dao.IUserDao_old;
import com.picontroller.home.model.HealthCheckStatus;
import com.picontroller.home.service.MonitoringService;

/**
 * Monitoring services exposed through Rest.
 * @author dcharles
 */

@RestController
public class MonitoringRestServices implements IMonitoringRestService{

	@Autowired
	MonitoringService monitoringService;
	
	@Override
	@RequestMapping("/ping")
	public @ResponseBody String ping(){
		return "OK";
	}

	@Override
	@RequestMapping("/healthCheck")
	public @ResponseBody HealthCheckStatus healthCheck() {
		return monitoringService.healthCheck();
	}
	
}
