package com.picontroller.home.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picontroller.home.model.User;
import com.picontroller.home.service.UserService;

/**
 * User services exposed through Rest.
 * 
 * @author dcharles
 */
@RestController
public class UserRestService implements IUserRestService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@Override
	@RequestMapping(method=RequestMethod.POST, value = "/user/authenticate")
	public @ResponseBody User authenticate(@RequestBody Map<String, String> parameters) throws Exception {
		log.info("Authenticating user " + parameters.get("userName") + " through Rest.");
		try {
			return userService.authenticate(parameters.get("userName"), parameters.get("password"));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@RequestMapping(method=RequestMethod.GET, value = "/user/authenticated")
	public @ResponseBody User getAuthenticatedUser() {
		return userService.getAuthenticatedUser();
	}
	
}
