package java4s;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 


import com.opensymphony.xwork2.ActionSupport;
public class Updates extends ActionSupport{
    private static final long serialVersionUID = 1L;
 
    Mybean mb=new Mybean();
    Connection con=null;
    public Mybean getMb() {
        return mb;
    }
    public void setMb(Mybean mb) {
        this.mb = mb;
    }
 
    public String execute()
    {
 
    try{
    	 con=DatabaseConnection.getConnection();
    		System.out.println("Connected........");
 
    String s = "update details set sname=?,scountry=? where sno=?";
    PreparedStatement ps=con.prepareStatement(s);
    ps.setString(1, mb.getNam());
    ps.setString(2, mb.getCt());
    ps.setInt(3, mb.getNo());
 
    ps.executeUpdate();
    con.commit();
 
        ps.close();
        con.close();
 
            }
        catch(Exception e){
            e.printStackTrace();
        }
 
            return SUCCESS;
 
    }
 
}