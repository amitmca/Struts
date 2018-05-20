package com.javahonk.action;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String location;
	private String message;
	

	@Override
	public String execute() throws Exception {
		message = "Your entered input values are:";
		return ActionSupport.SUCCESS;
	}
	
	@Override
	public void validate() {
		if (null == firstName || firstName.length() == 0)
			addActionError(getText("error.firstName.required"));
		if (null == lastName || lastName.length() == 0)
			addActionError(getText("error.lastName.required"));
		if (null == location || location.length() == 0)
			addActionError(getText("error.location.required"));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
