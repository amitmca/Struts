package java4s;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;
import java4s.DatabaseConnection;
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
		    String s = "insert into details values(?,?,?)";
		    ps=con.prepareStatement(s);
		    ps.setInt(1, mb.getNo());
		    ps.setString(2, mb.getNam());
		    ps.setString(3, mb.getCt());
		    System.out.println("Insert Done........");
		    ps.executeUpdate();
		    con.commit();
		    ps.close();
            con.close();
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