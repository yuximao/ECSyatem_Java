package com.singularity.EamilClassifivationSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singularity.EamilClassifivationSystem.http.Response;
import com.singularity.EamilClassifivationSystem.services.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@PreAuthorize("permitAll()")
	@GetMapping("/checkLogin")
	public Response checklogin(Authentication authentication) {
		return authService.checklogin(authentication);
	}
	
}
