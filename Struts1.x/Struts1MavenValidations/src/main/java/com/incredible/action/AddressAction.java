package com.incredible.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.incredible.dao.*;
 

import com.incredible.form.AddressForm;
 
public class AddressAction extends Action{
 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			AddressForm af = (AddressForm) form;
			CrudOperations coptr = null;
			    if(getErrors(request) == null ||getErrors(request).size() == 0)
			    {
			    	coptr=new CrudOperations();
			    	coptr.insertData(af);
			        return mapping.findForward("success");
			    }
			    else
			        return mapping.getInputForward();
			}

 
}