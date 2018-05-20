package com.tutorials4u.business;

import java.util.List;
import org.apache.log4j.Logger;
import com.tutorials4u.service.UserService;
import com.tutorials4u.model.User;

public class BusinessDelegate {
	private static final Logger logger = Logger
			.getLogger(BusinessDelegate.class);
	private UserService userDao = new UserService();

	public void insertUser(User user){
		logger.debug("BusinessDelegate.insertUser()");
		new UserService().insertUser(user);
	}

	public List<User> listUsers() {
		logger.debug("BusinessDelegate.listUsers()");
		List<User> users = userDao.getAllUsers();
		return users;
	}

	public void deleteUser(int userid) {
		logger.debug("BusinessDelegate.deleteUser()");
		userDao.deleteUser(userid);
	}

	public User editUser(int userid){
		logger.debug("UserAction.editUser()");
		User user = userDao.getUserById(userid);
		return user;
	}

	public void updateUser(User user) {
		logger.debug("UserAction.updateUser()");
		userDao.updateUser(user);
	}

}
