package com.test.sp1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sp1.dao.UserDAO;
import com.test.sp1.entity.User;
import com.test.sp1.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> getUserList() {
		return userDAO.findUserInfos();
	}

	@Override
	public long saveUser(User user) {
		userDAO.saveUser(user);
		return user.getUiNum();
		
	}
	
	@Override
	public long updateUser(User user) {
		userDAO.updateUser(user);
		return user.getUiNum();
	}

	@Override
	public long deleteUser(int uiId) {
		userDAO.deleteUser(uiId);
		if(userDAO.findUserByUiId(uiId)==null) {
			return 1;
		}
		return 0;
	}

}
