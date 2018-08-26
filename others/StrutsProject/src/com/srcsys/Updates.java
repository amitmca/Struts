package com.srcsys;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.srcsys.DatabaseConnection;
import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;
public class Updates extends ActionSupport{
    private static final long serialVersionUID = 1L;
    Connection con=null;
    Mybean mb=new Mybean();
 
    public Mybean getMb() {
        return mb;
    }
    public void setMb(Mybean mb) {
        this.mb = mb;
    }
 
    public String execute()
    {
    try
    	{
    	con=DatabaseConnection.getConnection();
	    String s = "update contactdetails set sname=?,scountry=? where sno=?";
	    PreparedStatement ps=con.prepareStatement(s);
	    ps.setString(1, mb.getName());
	    ps.setString(2, mb.getAddress());
	    ps.setString(3, mb.getEmail());
	    ps.setInt(4, mb.getContactNo());
	    ps.executeUpdate();
	    con.commit();
	    }
    catch(Exception e)
    	{
        e.printStackTrace();
        }
      return SUCCESS;
    }
 
}

