package com.kk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kk.entity.User;


public interface UserDao {

	User findByUsername(String username);
	User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	int addUser(User user);
	
	List<User> findAllUsers();
}
