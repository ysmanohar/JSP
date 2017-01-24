package com.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Connect {
	
	public Connection initiateConnction(){
		Connection conn = null; 
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "letsride";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!");
          }
        catch (Exception e) {
            e.printStackTrace();
        }
        
		return conn;
		
	}

}
