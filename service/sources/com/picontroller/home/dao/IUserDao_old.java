package com.picontroller.home.dao;

import com.picontroller.home.model.User;

/**
 * User Dao.
 * @author dcharles
 *
 */
public interface IUserDao_old {

	/**
	 * Get a user by his name.
	 * @param userName the name of the user.
	 * @return {@link User}
	 */
	User getByUserName(String userName);

	/**
	 * Get a user by his id.
	 * @param userId the id of the user.
	 * @return {@link User}
	 */
	User getByUserId(Integer userId);

}
