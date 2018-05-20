package com.tutorials4u.actions;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorials4u.model.User;
import com.tutorials4u.service.UserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ServletRequestAware {
	// Get a logger
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private UserService userDao = new UserService();
	private User user;
	HttpServletRequest request;
	
	private Object users,editusers;
	
	public Object getUsers() {
		return users;
	}

	public void setUsers(Object users) {
		this.users = users;
	}
	
	public Object getEditusers() {
		return editusers;
	}

	public void setEditusers(Object editusers) {
		this.editusers = editusers;
	}

	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	
	public String insertUser()	throws Exception {
			logger.debug("UserAction.insertUser()");
		new UserService().insertUser(user);
		logger.debug("1 Record Inserted Successfully ");
		return ActionSupport.SUCCESS;
	}

	
	public String listUsers()
			throws Exception {
		logger.debug("UserAction.listUsers()");
		users = userDao.getAllUsers();
		return ActionSupport.SUCCESS;
	}

	public String deleteUser()
			throws Exception {
		logger.debug("UserAction.deleteUser()");
		String userid=request.getQueryString();
		ArrayList<String> list=new ArrayList<String>();
		for(String newstr:userid.split("=")) {
			list.add(newstr);
		}
		logger.debug("value="+list.get(1));
		userDao.deleteUser(Integer.parseInt(list.get(1)));
		logger.debug("1 Record Deleted Successfully ");
		return ActionSupport.SUCCESS;
	}
	
	public String editUser()
			throws Exception {
		logger.debug("UserAction.editUser()");
		String userid=request.getQueryString();
		ArrayList<String> list=new ArrayList<String>();
		for(String newstr:userid.split("=")) {
			list.add(newstr);
		}
		editusers=userDao.getUserById(Integer.parseInt(list.get(1)));
		return ActionSupport.SUCCESS;
	}
	
	public String updateUser()
			throws Exception {
		logger.debug("UserAction.updateUser()");
		userDao.updateUser(user);
		logger.debug("1 Record Updated Successfully");
		return ActionSupport.SUCCESS;
	}

}
