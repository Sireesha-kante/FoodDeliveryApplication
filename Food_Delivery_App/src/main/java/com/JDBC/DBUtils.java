package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DBUtils {
	
	
	private static String url="jdbc:mysql://localhost:3306/food_delivery_app";
	private static String username="root";
	private static String password="root";
    private static Connection connection=null;
	public static Connection myconnect()
	{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection(url,username,password);
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					 e.printStackTrace();
				}
		return connection;
	}
}
