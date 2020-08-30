package com.singularity.EamilClassifivationSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singularity.EamilClassifivationSystem.services.UserInfoService;

@RestController
@RequestMapping("/userInfos")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

}
