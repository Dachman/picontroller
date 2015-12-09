package com.picontroller.home.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.picontroller.home.model.User;

@Repository
public interface IUserRepository extends CassandraRepository<User> {
		
	@Query("Select * from user where userName=?0")
	User getByUserName(String userName);

	@Query("Select * from user where userId=?0")
	User getByUserId(int userId);

	@Query("Select * from user where userName=?0 and userPassword=?1 ALLOW FILTERING")
	User authenticate(String userName, String userPassword);

}
