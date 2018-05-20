package com.tutorials4u.actions;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.tutorials4u.business.BusinessDelegate;
import com.tutorials4u.model.User;

public class UserAction extends MappingDispatchAction {
	// Get a logger
		private static final Logger logger = Logger
				.getLogger(UserAction.class);
	BusinessDelegate businessDelegate;

	public BusinessDelegate getBusinessDeletage() {
        return businessDelegate;
    }
 
    public void setBusinessDelegate(BusinessDelegate businessDeletage) {
        this.businessDelegate = businessDeletage;
    }
    

	public ActionForward listUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("UserAction.listUsers()");
		List<User> users=this.businessDelegate.listUsers();
		request.setAttribute("users", users);
		return mapping.findForward("success");
	}
	
	public ActionForward insertUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) form;
		logger.debug("UserAction.insertUser()");
		String result=this.businessDelegate.insertUser(user);
		logger.debug("1 Record Inserted Successfully " + result);
		return mapping.findForward("success");
	}
	
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("UserAction.deleteUser()");
		String userid = request.getQueryString();
		ArrayList<String> list = new ArrayList<String>();
		for (String newstr : userid.split("=")) {
			list.add(newstr);
		}
		logger.debug("value=" + list.get(1));
		this.businessDelegate.deleteUser(Integer.parseInt(list.get(1)));
		return mapping.findForward("success");
	}
	
	public ActionForward editUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("UserAction.editUser()");
		String userid = request.getQueryString();
		ArrayList<String> list = new ArrayList<String>();
		for (String newstr : userid.split("=")) {
			list.add(newstr);
		}
		User user = this.businessDelegate.editUser(Integer.parseInt(list.get(1)));
		request.setAttribute("user", user);
		return mapping.findForward("success");
	}
	
	public ActionForward updateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) form;
		logger.debug("UserAction.updateUser()");
		this.businessDelegate.updateUser(user);
		logger.debug("1 Record Updated Successfully");
		return mapping.findForward("success");
	}

}
