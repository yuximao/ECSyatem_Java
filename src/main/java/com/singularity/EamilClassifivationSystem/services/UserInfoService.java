package com.singularity.EamilClassifivationSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singularity.EamilClassifivationSystem.daos.UserInfoDao;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

}
