package com.test.sp1.service;

import java.util.List;

import com.test.sp1.entity.User;

public interface UserService {

	List<User> getUserList();
	
	long saveUser(User user);
	
	long updateUser(User user);
	
	long deleteUser(int uiId);
	
	
}
