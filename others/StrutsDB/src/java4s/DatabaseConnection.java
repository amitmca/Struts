package java4s;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

/*public class DatabaseConnection {
private static Connection connection = null;
	
	public static Connection getConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "system");
	      props.setProperty("password", "123456");


	      if(connection == null ) {
				try {
					 Class.forName("oracle.jdbc.OracleDriver").newInstance();
				      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",props);
				      System.out.println("Connected To Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}
}
*/

public class DatabaseConnection {
private static Connection connection = null;
	
	public static Connection getConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "root");
	      props.setProperty("password", "");


	      if(connection == null ) {
				try {
					 Class.forName("com.mysql.jdbc.Driver").newInstance();
				      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/strutsdb",props);
				      System.out.println("Connected To Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}
}