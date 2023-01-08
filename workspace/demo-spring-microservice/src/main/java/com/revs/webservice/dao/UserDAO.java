package com.revs.webservice.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.revs.webservice.entity.User;

@Repository
public class UserDAO {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userId = 1;
	
	static {
		users.add(new User(userId++, "Saji", LocalDate.now().minusYears(40)));
		users.add(new User(userId++, "Kiran", LocalDate.now().minusMonths(17)));
		users.add(new User(userId++, "Shiva", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		Predicate<User> predicate = user -> user.getId() == id;
		User user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}

	public User save(User user) {
		user.setId(userId++);
		users.add(user);
		return user;
	}
	
	public void removeById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
}
