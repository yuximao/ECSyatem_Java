package com.singularity.EamilClassifivationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.singularity.EamilClassifivationSystem.beans.User;
import com.singularity.EamilClassifivationSystem.beans.UserInfo;
import com.singularity.EamilClassifivationSystem.daos.UserDao;
import com.singularity.EamilClassifivationSystem.daos.UserInfoDao;
import com.singularity.EamilClassifivationSystem.http.Response;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserInfoDao userInfoDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}

	public User getUserById(long id) {
		System.out.println("user service yes");
		return userDao.findById(id).get();
	}

	public Response register(User user) {

		String orginPassword = user.getPassword();
		// System.out.println("userService: orginPassword: " + user.getPassword());

		String hashedPassword = BCrypt.hashpw(orginPassword, BCrypt.gensalt());
		// System.out.println("userService: hashedPassword: " + hashedPassword);

		user.setUsername(user.getUsername());
		user.setPassword(hashedPassword);
		user.setEmail(user.getEmail());
		
		System.out.println("userService: user: " + user);

		if (userDao.findByUsername(user.getUsername()) != null || orginPassword.equals("")) {
			return new Response(false);
		} else {
			UserInfo ui = new UserInfo();
			ui.setFirstName(user.getUserInfo().getFirstName());
			ui.setLastName(user.getUserInfo().getLastName());
			ui.setMiddleName(user.getUserInfo().getMiddleName());
			ui.setPhoneNumber(user.getUserInfo().getPhoneNumber());
			ui.setOccupation(user.getUserInfo().getOccupation());
			ui.setMailAddress(user.getUserInfo().getMailAddress());
			user.setUserInfo(ui);
			
			ui.setUser(user);
			userDao.save(user);
			return new Response(true);
		}

	}

    public List<User> checkByUsername(String username) { return userDao.checkByUsername(username);}


}
