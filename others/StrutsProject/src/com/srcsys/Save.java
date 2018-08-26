package com.srcsys;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;
import com.srcsys.DatabaseConnection;
import java.sql.Connection;

public class Save extends ActionSupport
	{
    private static final long serialVersionUID = 1L;
    PreparedStatement ps=null;
    Connection con=null;
    Mybean mb=new Mybean();
 
    public Mybean getMb() 
    	{
        return mb;
    	}
    
    public void setMb(Mybean mb) 
    	{
        this.mb = mb;
    	}
 
    public String execute()
    	{
    	try
    		{
		    con=DatabaseConnection.getConnection();
		    System.out.println("Connected........");
		    String s = "insert into contactdetails values(?,?,?,?,?)";
		    ps=con.prepareStatement(s);
		    ps.setInt(1, mb.getContactId());
		    ps.setString(2, mb.getName());
		    ps.setString(3, mb.getAddress());
		    ps.setString(4, mb.getEmail());
		    ps.setInt(5, mb.getContactNo());
		    System.out.println("Insert Done........");
		    ps.executeUpdate();
		    con.commit();
		    //ps.close();
            //con.close();
		    }
        catch(Exception e)
        	{
        
            e.printStackTrace();
        	}
    	finally
    		{
    		
      		}
     return SUCCESS;
    }
 
}