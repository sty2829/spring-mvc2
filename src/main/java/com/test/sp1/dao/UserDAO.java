package com.test.sp1.dao;

import java.util.List;

import com.test.sp1.entity.User;

public interface UserDAO {

	List<User> findUserInfos();
	
	User findUserByUiId(int uiId);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int uiId);
}
