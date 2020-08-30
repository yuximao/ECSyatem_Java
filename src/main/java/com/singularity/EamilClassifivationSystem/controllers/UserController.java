package com.singularity.EamilClassifivationSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singularity.EamilClassifivationSystem.beans.User;
import com.singularity.EamilClassifivationSystem.http.Response;
import com.singularity.EamilClassifivationSystem.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping()
	public Response addUser(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping("/checkuser")
	public boolean checkUser(@RequestBody String username) {
		if (userService.checkByUsername(username).size() > 0) {
            return true;
        } else {
            return false;
        }
	}
}
