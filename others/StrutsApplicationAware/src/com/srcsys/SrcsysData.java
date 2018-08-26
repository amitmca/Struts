package com.srcsys;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.*;
import java.util.Map;
public class SrcsysData extends ActionSupport implements ApplicationAware{
    private static final long serialVersionUID = 1L;
 
    private String uname,country;
    private int age;
    Map m;
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public void setApplication(Map m)
    {
        this.m=m;
    }
 
    public String execute()
    {
        m.put("a",uname);
        m.put("b", age);
        m.put("c",country);
 
        return SUCCESS;
    }
    public void validate()
    {
    if(uname.equals("") || uname.length()==0)
    	this.addFieldError("uname",getText("user.wrong"));
    
    if(country.equals("") || country.length()==0)
    	this.addFieldError("country",getText("country.wrong"));
    
    }
}
