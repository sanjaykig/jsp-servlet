package com.sanjay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTIL {
	public static Connection conn;

	public static Connection initConnection() {
		if( conn != null )
			return conn;

		//InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "/db.properties" );
		//Properties properties = new Properties();
		try
        {
			Class.forName("com.mysql.jdbc.Driver");  
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elib","root","newrootpassword");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return conn;        
	}
		
	

	public static void closeConnection( Connection toBeClosed ) {
		if( toBeClosed == null )
			return;
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
