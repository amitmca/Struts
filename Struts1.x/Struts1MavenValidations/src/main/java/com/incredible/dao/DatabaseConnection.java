package com.incredible.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
	private static Connection connection = null;

	public static Connection getMysqlConnection() {
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("password", "");

		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/strutsdb", props);
				System.out.println("Connected To Mysql Datasbase");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;

	}

}

/*
 * Mysql Procedure Code to insert values
 DELIMITER $$
CREATE PROCEDURE insertAddress(
	   IN p_name varchar(20),
	   IN p_street varchar(25),
	   IN p_city varchar(30),
	   IN p_country varchar(50),
	   IN p_pin Int(6))

BEGIN
 
  INSERT INTO ADDRESS (NAME, STREET, CITY, COUNTRY,PIN) 
  VALUES (p_name, p_street,p_city, p_country,p_pin);
 
 
END$$
DELIMITER ;
*/
  
