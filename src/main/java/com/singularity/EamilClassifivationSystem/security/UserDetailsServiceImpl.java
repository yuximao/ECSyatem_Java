package com.singularity.EamilClassifivationSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.singularity.EamilClassifivationSystem.beans.User;
import com.singularity.EamilClassifivationSystem.daos.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException(username + " Not Found!");
		}
	}

}
