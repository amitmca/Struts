package com.tutorials4u.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
	private static Connection connection = null;
	InputStream inputStream;
	String propFileName = "jdbc.properties";
	public static Properties prop = new Properties();
	public JDBCUtil() throws IOException {
		inputStream = getClass().getClassLoader().getResourceAsStream(
				propFileName);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}
	}
	public static Connection getMysqlConnection() throws IOException {
		String driverClass = prop.getProperty("jdbc.driverClassName");
		String url = prop.getProperty("jdbc.url");
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");

		if (connection == null) {
			try {
				Class.forName(driverClass).newInstance();
				connection = DriverManager.getConnection(url, username,
						password);
				System.out.println("Connected To Mysql Datasbase");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
}