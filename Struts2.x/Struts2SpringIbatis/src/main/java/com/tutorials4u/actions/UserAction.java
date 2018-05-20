package com.tutorials4u.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.tutorials4u.business.BusinessDelegate;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorials4u.model.User;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ServletRequestAware {
	// Get a logger
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private User user;
	HttpServletRequest request;
	BusinessDelegate businessDelegate;
	private Object users,editusers;

	public BusinessDelegate getBusinessDeletage() {
        return businessDelegate;
    }
 
    public void setBusinessDelegate(BusinessDelegate businessDeletage) {
        this.businessDelegate = businessDeletage;
    }
    
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
		String result = this.businessDelegate.insertUser(user);
		logger.debug("1 Record Inserted Successfully " + result);
		return ActionSupport.SUCCESS;
	}

	
	public String listUsers()
			throws Exception {
		logger.debug("UserAction.listUsers()");
		users = this.businessDelegate.listUsers();
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
		this.businessDelegate.deleteUser(Integer.parseInt(list.get(1)));
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
		editusers=this.businessDelegate.editUser(Integer.parseInt(list.get(1)));
		return ActionSupport.SUCCESS;
	}
	
	public String updateUser()
			throws Exception {
		logger.debug("UserAction.updateUser()");
		this.businessDelegate.updateUser(user);
		logger.debug("1 Record Updated Successfully");
		return ActionSupport.SUCCESS;
	}


}
