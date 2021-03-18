package com.atyeti.rest.servcice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.atyeti.rest.model.User;

@Component

public class UserService {

	public static List<User> userlist = new ArrayList<>();

	static {
		userlist.add(new User(1, "vaibhav", "admin"));
		userlist.add(new User(2, "shilpa", "user"));
		userlist.add(new User(3, "avinash", "admin"));

	}
	static int sizeCount = 3;

	public List<User> getUserData() {
		return userlist;

	}

	public User getUser(int id) {

		for (User user : userlist) {

			if (user.getId() == id) {
				return user;
			}

		}
		return null;

	}
	
	public User createUser(User user) {
		if (user.getId() == null) {
			user.setId(++sizeCount);
		}
		userlist.add(user);
		return user;

}
}