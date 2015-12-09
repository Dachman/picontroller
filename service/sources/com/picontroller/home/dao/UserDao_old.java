package com.picontroller.home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.picontroller.home.model.User;

@Repository
public class UserDao_old implements IUserDao_old {

	@Autowired
	CassandraOperations cassandraOps;
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public User getByUserName(String userName) {
		/*Select s = QueryBuilder.select().from("user");
		s.where(QueryBuilder.eq("userName", userName));
		return cassandraOps.selectOne(s, User.class);*/
		return userRepository.getByUserName(userName);
	}

	@Override
	public User getByUserId(Integer userId) {
		return cassandraOps.selectOneById(User.class, userId);
	}

}