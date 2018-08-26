package com.srcsys;
import com.opensymphony.xwork2.ActionSupport;
public class Srcsys {

    private static final long serialVersionUID = 1L;
 
    private String uname;
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String execute()
    {
        return "success";
    }
 
}