package com.picontroller.home.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.picontroller.home.dao.IUserRepository;

@Service("userDetailserviceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.picontroller.home.model.User user = userRepository.getByUserName(userName);
		if (user != null) {
			return new User(user.getUserName(), user.getUserPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(user.getUserRole()));
		} else {
			throw new UsernameNotFoundException("Could not find user " + userName + ".");
		}
	}

}
