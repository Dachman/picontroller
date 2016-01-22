package com.picontroller.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.picontroller.home.dao.IUserRepository;
import com.picontroller.home.model.User;

@Service("userService")
public class UserService implements IUserSevice {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IUserRepository userRepository;

	@Override
	public User authenticate(String userName, String password) throws Exception {
		log.debug("Authenticating user " + userName + ".");
		final User authenticatedUser = userRepository.authenticate(userName, password);
		if (authenticatedUser == null) {
			log.info("User " + userName + " failed to authenticate.");
			throw new Exception("User " + userName + " failed to authenticate.");
		} else {
			return authenticatedUser;
		}
	}

	@Override
	public User getByUserName(String userName) {
		log.debug("Looking for user " + userName + " (userName).");
		final User user = userRepository.getByUserName(userName);
		if (user == null) {
			log.info("User " + userName + " not found.");
		}
		return user;
	}

	@Override
	public User getByUserId(Integer userId) {
		log.debug("Looking for user" + userId + " (userId).");
		final User user = userRepository.getByUserId(userId);
		if (user == null) {
			log.info("User " + userId + " not found.");
		}
		return user;
	}

	@Override
	public User getAuthenticatedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.debug("Getting authenticated user " + auth.getName() + " (userName).");
		return getByUserName(auth.getName());
	}
}
