package com.tutorials4u.business;

import java.util.List;
import org.apache.log4j.Logger;
import com.tutorials4u.dao.UserDao;
import com.tutorials4u.model.User;

public class BusinessDelegate {
	private static final Logger logger = Logger
			.getLogger(BusinessDelegate.class);
	private UserDao userDao = new UserDao();

	public String insertUser(User user){
		logger.debug("BusinessDelegate.insertUser()");
		String result = new UserDao().insertUser(user);
		return result;
	}

	public List<User> listUsers() {
		logger.debug("BusinessDelegate.listUsers()");
		List<User> users = userDao.listUsers();
		return users;
	}

	public void deleteUser(int userid) {
		logger.debug("BusinessDelegate.deleteUser()");
		userDao.deleteUser(userid);
	}

	public User editUser(int userid){
		logger.debug("UserAction.editUser()");
		User user = userDao.editUser(userid);
		return user;
	}

	public void updateUser(User user) {
		logger.debug("UserAction.updateUser()");
		userDao.updateUser(user);
	}

}
