package com.srcsys;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.srcsys.DatabaseConnection;
 
public class Display extends ActionSupport implements ServletRequestAware
	{
    private static final long serialVersionUID = 1L;
 
    HttpServletRequest request;
 
    public String execute()
    {
 
    try
    	{
    	java.sql.Connection con =DatabaseConnection.getConnection();
    	PreparedStatement st=con.prepareStatement("select * from contactdetails");
    	ResultSet rs = st.executeQuery();
        List li = new ArrayList();
        Mybean mb=null;
 
        while(rs.next())
            {
        		mb = new Mybean();
                mb.setContactId(rs.getInt("contactid"));
                mb.setName(rs.getString("name"));
                mb.setAddress(rs.getString("address"));  
                mb.setEmail(rs.getString("email"));
                mb.setContactNo(rs.getInt("contactno"));
                li.add(mb);
            }
        request.setAttribute("disp", li);
        rs.close();
        st.close();
       // con.close();
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
        return SUCCESS;
    }
 
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
 
    public HttpServletRequest getServletRequest() {
        return request;
    }
 
}