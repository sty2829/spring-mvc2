package com.test.sp1.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.sp1.dao.UserDAO;
import com.test.sp1.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findUserInfos() {
		List<User> userList = em.createQuery("from User order by uiNum", User.class).getResultList();
		return userList;
	}

	@Override
	public User findUserByUiId(long uiId) {
		return em.find(User.class, uiId);
	}

	@Override
	public void saveUser(User user) {
		em.persist(user);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override
	public void deleteUser(long uiId) {
		User user = findUserByUiId(uiId);
		em.remove(user);
	}

}
