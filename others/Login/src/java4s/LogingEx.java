package java4s;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;


public class LogingEx extends ActionSupport{
    private static final long serialVersionUID = 1L;
 
    private String uname,password;
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String execute()
    {
        if(LoginCheck())
			return SUCCESS;
		else
            this.addActionError(getText("u.p.wrong"));
            return ERROR;
    	}
 
    public void validate()
    	{
        if(uname.equals("") || uname.length()==0)
            this.addFieldError("uname",getText("user.wrong"));
        if(password.equals("") || password.length()==0)
            this.addFieldError("password",getText("pass.wrong"));
    	}
    
    @SuppressWarnings("finally")
	public boolean LoginCheck()
    	{
    	 @SuppressWarnings("unused")
		boolean isValidUser=false;
    	 Connection conn=null;
    	 String user="",pass="";
    	 try
    	 	{
    		 conn=java4s.DatabaseConnection.getConnection();
    		 PreparedStatement st=conn.prepareStatement("select * from login where user = ? and pass = ? ");
    		 st.setString(1,uname);
    		 st.setString(2,password);
    	     ResultSet rs = st.executeQuery();
    	     while(rs.next())
             	{
    	    	 user=rs.getString(3);
    	    	 pass=rs.getString(4);
    	    	 System.out.println("Username:::"+user+"\nPassword:::"+pass);
             	}
    	     
    	 	}
    	 catch(Exception e)
    	 	{
    	 	System.out.println("Error Is :: "+e.getMessage());
    	 	}
    	 finally
    	 	{
    		 if(user.equals(uname) && pass.equals(password))
    			 return isValidUser=true;
       		 else  return isValidUser=false;
    	 	}
    	}
    }
 
