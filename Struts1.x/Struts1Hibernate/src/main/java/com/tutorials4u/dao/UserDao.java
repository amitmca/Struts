package com.tutorials4u.dao;

//import java.util.List;

import java.util.List;

import org.hibernate.Session;
import org.apache.log4j.Logger;
import com.tutorials4u.actions.UserAction;
import com.tutorials4u.hibernate.HibernateUtil;
import com.tutorials4u.model.User;

public class UserDao {
	// Get a logger
	private static final Logger logger = Logger.getLogger(UserAction.class);

	public String insertUser(User newuser) {
		logger.debug("UserDao.createUser()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = new User();
			user.setUsername(newuser.getUsername());
			user.setPassword(newuser.getPassword());
			user.setFirstName(newuser.getFirstName());
			user.setLastName(newuser.getLastName());
			user.setEmailId(newuser.getEmailId());
			user.setPhone(newuser.getPhone());
			logger.debug("Inserting values....");
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Error creating User :" + e.getMessage());
			session.getTransaction().rollback();
			return "failure";
		}
		return "success";
	}

	public List<User> listUsers() {
		logger.debug("UserDao.listUsers()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("From User").list();
	}
	
	public void deleteUser(int id) {
		logger.debug("UserDao.deleteUser()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = getUser(id);
		session.delete(user);
		session.getTransaction().commit();
	} 
	
	public User editUser(int id) {
		logger.debug("UserDao.editUser()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = getUser(id);
		return user;
	}
	
	public User getUser(int id) {
		logger.debug("UserDao.getUser()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	public void updateUser(User user) {
		logger.debug("UserDao.updateUser()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	} 
}