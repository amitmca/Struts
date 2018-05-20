package com.tutorials4u.dao;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.tutorials4u.actions.UserAction;
import com.tutorials4u.ibatis.IbatisUtil;
import com.tutorials4u.model.User;

public class UserDao {
	// Get a logger
	private static final Logger logger = Logger.getLogger(UserAction.class);
	SqlMapClient sqlmapClient = IbatisUtil.initateSqlMapClient();

	public String insertUser(User user) {
		logger.debug("UserDao.insertUser()");
		try {
			logger.debug("Inserting values....");
			sqlmapClient.insert("user.insertUser", user);
		} catch (Exception e) {
			logger.error("Error creating User :" + e.getMessage());
			return "failure";
		}
		return "success";
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() throws SQLException {
		logger.debug("UserDao.listUsers()");
		User rec = new User();
		List<User> user = (List<User>) sqlmapClient.queryForList(
				"user.listUsers", rec);
		return user;
	}

	public void deleteUser(int id) {
		logger.debug("UserDao.deleteUser()");
		try {
			sqlmapClient.delete("user.deleteUser", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User editUser(int id) throws SQLException {
		logger.debug("UserDao.editUser()");
		User user = getUser(id);
		return user;
	}

	public User getUser(int id) throws SQLException {
		logger.debug("UserDao.getUser()");
		User user = (User) sqlmapClient.queryForObject("user.getUserById", id);
		return user;
	}

	public void updateUser(User user) {
		logger.debug("UserDao.updateUser()");
		try {
			sqlmapClient.update("user.updateUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}