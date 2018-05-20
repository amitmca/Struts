package com.tutorials4u.business;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.tutorials4u.dao.UserDao;
import com.tutorials4u.model.User;

public class BusinessDelegate {
	private static final Logger logger = Logger
			.getLogger(BusinessDelegate.class);
	private UserDao userDao = new UserDao();

	public void insertUser(User user) throws IOException, SQLException{
		logger.debug("BusinessDelegate.insertUser()");
		new UserDao().insertUser(user);
	}

	public List<User> listUsers() throws IOException, SQLException {
		logger.debug("BusinessDelegate.listUsers()");
		List<User> users = userDao.getAllUsers();
		return users;
	}

	public void deleteUser(int userid) throws IOException, SQLException {
		logger.debug("BusinessDelegate.deleteUser()");
		userDao.deleteUser(userid);
	}

	public User editUser(int userid) throws IOException, SQLException{
		logger.debug("UserAction.editUser()");
		User user = userDao.getUserById(userid);
		return user;
	}

	public void updateUser(User user) throws IOException {
		logger.debug("UserAction.updateUser()");
		userDao.updateUser(user);
	}

}
