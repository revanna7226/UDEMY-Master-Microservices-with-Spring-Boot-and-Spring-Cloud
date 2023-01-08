package com.revs.webservice.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revs.webservice.dao.UserDAO;
import com.revs.webservice.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	public User getUserById(int id) {
		User user = userDao.findById(id);
		return user;
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public void deleteUserById(int id) {
		userDao.removeById(id);
	}
	
}
