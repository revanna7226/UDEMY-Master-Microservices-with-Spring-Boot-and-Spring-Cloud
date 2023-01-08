package com.revs.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revs.webservice.dao.UserJpaDao;
import com.revs.webservice.entity.User;

@Service
public class UserJpaService {

	@Autowired
	private UserJpaDao userDao;
	
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	public Optional<User> getUserById(int id) {
		Optional<User> user = userDao.findById(id);
		return user;
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public void deleteUserById(int id) {
		userDao.deleteById(id);
	}
	
	
	
}
