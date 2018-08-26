package java4s;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import java4s.DatabaseConnection;
 
public class Display extends ActionSupport implements ServletRequestAware
	{
    private static final long serialVersionUID = 1L;
 
    HttpServletRequest request;
    Connection con=null;
    public String execute()
    {
 
    try
    	{
    	con=DatabaseConnection.getConnection();
		System.out.println("Connected........");
    	PreparedStatement st=con.prepareStatement("select * from details");
    	ResultSet rs = st.executeQuery();
        List li = new ArrayList();
        Mybean mb=null;
 
        while(rs.next())
            {
        		mb = new Mybean();
                mb.setNo(rs.getInt("sno"));
                mb.setNam(rs.getString("sname"));
                mb.setCt(rs.getString("scountry"));      
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