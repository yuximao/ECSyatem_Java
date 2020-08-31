package com.singularity.EamilClassifivationSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singularity.EamilClassifivationSystem.beans.UserInfo;
import com.singularity.EamilClassifivationSystem.services.UserInfoService;
import com.singularity.EamilClassifivationSystem.http.Response;



@RestController
@RequestMapping("/userInfos")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PutMapping()
	public Response updateUserInfo(@RequestBody UserInfo userInfo) {
		System.out.println("updateUserInfo: " + userInfo);
		return userInfoService.updateToUserInfo(userInfo);
	}

}
