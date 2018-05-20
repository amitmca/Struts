package com.tutorials4u.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.tutorials4u.actions.UserAction;
import com.tutorials4u.jdbc.JDBCUtil;
import com.tutorials4u.model.User;

public class UserDao {
	private static final Logger logger = Logger.getLogger(UserAction.class);

	PreparedStatement stmt = null;

	@SuppressWarnings("static-access")
	public String insertUser(User newuser) throws IOException, SQLException {
		logger.debug("UserDao.createUser()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		try {
			String username = newuser.getUsername();
			String password = newuser.getPassword();
			String firstname = newuser.getFirstName();
			String lastname = newuser.getLastName();
			String emailId = newuser.getEmailId();
			String phone = newuser.getPhone();

			String sql = new String(
					"insert into myuser(USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONE,EMAILID) values(?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, firstname);
			stmt.setString(4, lastname);
			stmt.setString(5, phone);
			stmt.setString(6, emailId);

			logger.debug("Inserting values....");
			stmt.executeUpdate();
		} catch (Exception e) {
			logger.error("Error creating User :" + e.getMessage());
			return "failure";
		} finally {
			stmt.close();
			conn.close();
		}
		return "success";
	}

	@SuppressWarnings("static-access")
	public List<User> listUsers() throws IOException, SQLException {
		logger.debug("UserDao.listUsers()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		ResultSet result = null;
		Statement statement = null;
		List<User> users = new ArrayList<User>();
		try {
			String sql = "select USER_ID,USERNAME,FIRSTNAME,LASTNAME,PHONE,EMAILID from myuser";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			User newuser = null;
			while (result.next()) {
				newuser = new User();
				newuser.setUser_id(result.getInt("USER_ID"));
				newuser.setUsername(result.getString("USERNAME"));
				newuser.setFirstName(result.getString("FIRSTNAME"));
				newuser.setLastName(result.getString("LASTNAME"));
				newuser.setPhone(result.getString("PHONE"));
				newuser.setEmailId(result.getString("EMAILID"));
				users.add(newuser);
			}
		} catch (SQLException e) {
			logger.error("Error listing Users :" + e.getMessage());
		} finally {
			result.close();
			statement.close();
			// conn.close();
		}
		return users;
	}

	@SuppressWarnings("static-access")
	public void deleteUser(int id) throws IOException, SQLException {
		logger.debug("UserDao.deleteUser()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		Statement statement = null;
		try {
			String sql = "delete from myuser where user_id=" + id;
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("Error deleting User :" + e.getMessage());
		} finally {
			statement.close();
			// conn.close();
		}
	}

	@SuppressWarnings("static-access")
	public User editUser(int id) throws IOException, SQLException {
		logger.debug("UserDao.editUser()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		User user = getUser(id);
		return user;
	}

	@SuppressWarnings("static-access")
	public User getUser(int id) throws SQLException, IOException {
		logger.debug("UserDao.getUser()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		ResultSet result = null;
		Statement statement = null;
		User newuser = null;
		try {
			String sql = "select USER_ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONE,EMAILID from myuser WHERE USER_ID="
					+ id;
			statement = conn.createStatement();
			result = statement.executeQuery(sql);

			while (result.next()) {
				newuser = new User();
				newuser.setUser_id(result.getInt("USER_ID"));
				newuser.setUsername(result.getString("USERNAME"));
				newuser.setPassword(result.getString("PASSWORD"));
				newuser.setFirstName(result.getString("FIRSTNAME"));
				newuser.setLastName(result.getString("LASTNAME"));
				newuser.setPhone(result.getString("PHONE"));
				newuser.setEmailId(result.getString("EMAILID"));
			}
		} catch (SQLException e) {
			logger.error("Error listing Users :" + e.getMessage());
		} finally {
			result.close();
			statement.close();
			// conn.close();
		}
		return newuser;
	}

	@SuppressWarnings("static-access")
	public void updateUser(User newuser) throws IOException {
		logger.debug("UserDao.updateUser()");
		JDBCUtil util = new JDBCUtil();
		Connection conn = util.getMysqlConnection();
		try {
			int userid  = newuser.getUser_id();
			String username = newuser.getUsername();
			String password = newuser.getPassword();
			String firstname = newuser.getFirstName();
			String lastname = newuser.getLastName();
			String emailId = newuser.getEmailId();
			String phone = newuser.getPhone();

			String sql = "UPDATE MYUSER SET USERNAME=?,PASSWORD=?,FIRSTNAME=?,LASTNAME=?,PHONE=?,EMAILID=? WHERE USER_ID="+userid;

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, firstname);
			stmt.setString(4, lastname);
			stmt.setString(5, phone);
			stmt.setString(6, emailId);

			logger.debug("Updating values....");
			stmt.executeUpdate();
		} catch (Exception e) {
			logger.error("Error updating User :" + e.getMessage());
		} 
	}

}