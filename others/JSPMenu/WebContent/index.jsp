<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Jsp Menu</title>
<link rel="stylesheet" type="text/css" href="css/jqueryslidemenu.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jqueryslidemenu.js"></script>
</head>
<body>

<div id='myslidemenu' class='jqueryslidemenu'>
<ul>
<%
Connection conn=null;
Statement st=null,st1=null;
ResultSet rs=null,rs1=null;
int count=0;
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
			conn=DriverManager.getConnection(url,"root","");
			st=conn.createStatement();
			String sql="select * from form_mst";
			rs=st.executeQuery(sql);
			String menuname="",submenu="",menuid="",parentid="";
			while(rs.next())
				{
				menuname=rs.getString("caption");
				submenu=rs.getString("sub_menu");
				menuid=rs.getString("menuid");
				parentid=rs.getString("parentid");
				if(submenu.equals("Y"))   
					{
					st1=conn.createStatement();
					String countqry="select count(*) as count from form_mst f where f.parentid='"+menuid+"'";
					rs1=st1.executeQuery(countqry);
					while(rs1.next())
						{
						count=Integer.parseInt(rs1.getString("count"));
						}
					for(int i=0;i<count;i++)
						{
						
					 %>

<%				
						}
			}		
				}
			}

		catch(Exception e)
			{
			out.println(e);
			}
		

%>

</ul>
</div>
</body>

</html>
