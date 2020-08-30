package com.singularity.EamilClassifivationSystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.singularity.EamilClassifivationSystem.beans.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
	 @Query(value = "select *  from ECS_USER where username =:username", nativeQuery = true)
		List<User> checkByUsername(@Param("username") String username);  
}
