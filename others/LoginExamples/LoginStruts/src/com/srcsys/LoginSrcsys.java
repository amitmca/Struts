package com.srcsys;
import com.opensymphony.xwork2.ActionSupport;
public class LoginSrcsys extends ActionSupport {
	private static final long serialVersionUID = 1L;
	 
    private String uname;
    private String pass;
 
    public String getUname() {
        return uname;
    }
    
    public String getPassword() {
    	return pass;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    public void setPassword(String pass) {
    	this.pass=pass;
    }
    
    public String execute()
    {
    	if(uname.equals("amit")){
    		return SUCCESS;
    	}
    	else
    		return ERROR;
    }
}
