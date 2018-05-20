package com.incredible.dao;
import java.sql.Connection;
import java.sql.SQLException;

import com.incredible.form.AddressForm;

public class CrudOperations {
	Connection conn = null;
	 public void insertData(AddressForm af)
	            throws Exception {
		    conn=DatabaseConnection.getMysqlConnection();
		    java.sql.CallableStatement insertstat=null;
	        try {
	            try {
	                /*Statement st = conn.createStatement();
	                int val = st
	                        .executeUpdate("INSERT INTO address(name,street,city,country,pin) VALUES('"+ af.getName() + "','" + af.getStreet() + "','" + af.getCity() + "','" + af.getCountry() + "','" + af.getPin() + "')");
	                */
	            	insertstat=conn.prepareCall("{call insertAddress(?,?,?,?,?)}");
	 			    insertstat.setString(1,af.getName());
	 			    insertstat.setString(2,af.getStreet());
	 			    insertstat.setString(3,af.getCity());
	 			    insertstat.setString(4,af.getCountry());
	 			    insertstat.setInt(5,af.getPin());
	 			    insertstat.executeUpdate();
	 			    
	               System.out.println("1 row affected");
	            } catch (SQLException ex) {
	                System.out.println("SQL statement is not executed!" + ex);
	            }
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
