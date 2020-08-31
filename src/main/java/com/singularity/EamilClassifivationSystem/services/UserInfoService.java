package com.singularity.EamilClassifivationSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singularity.EamilClassifivationSystem.beans.UserInfo;
import com.singularity.EamilClassifivationSystem.daos.UserInfoDao;
import com.singularity.EamilClassifivationSystem.http.Response;


@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	public Response updateToUserInfo(UserInfo userInfo) {
		try {
			UserInfo userInfoUpdate = userInfoDao.findById(userInfo.getId()).get();
			userInfoUpdate.setFirstName(userInfo.getFirstName());
			userInfoUpdate.setLastName(userInfo.getLastName());
			userInfoUpdate.setPhoneNumber(userInfo.getPhoneNumber());
			userInfoUpdate.setMiddleName(userInfo.getMiddleName());
			userInfoUpdate.setOccupation(userInfo.getOccupation());
			userInfoUpdate.setUser(userInfoUpdate.getUser());
			userInfoUpdate.setMailAddress(userInfo.getMailAddress());
			System.out.println(userInfoUpdate);
			userInfoDao.save(userInfoUpdate);

			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}

}
