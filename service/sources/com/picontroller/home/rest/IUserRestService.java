package com.picontroller.home.rest;

import java.util.Map;

import com.picontroller.home.model.User;

public interface IUserRestService {

	/**
	 * Authenticate a user.
	 * 
	 * @param parameters
	 *            "userName" and "password"
	 * @return authenticated user
	 * @throws Throwable
	 *             Authentication exception.
	 */
	User authenticate(Map<String, String> parameters) throws Throwable;

	/**
	 * Get the authenticated user.
	 * 
	 * @return the authenticated user.
	 */
	User getAuthenticatedUser();
}
