package com.singularity.EamilClassifivationSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singularity.EamilClassifivationSystem.beans.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

}
