package com.lazy.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	
	static{
		try {
			Class.forName(Infomation.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("init driver error !",e);
		}
	}
	
	
	public static java.sql.Connection connect() {
		
		try {
			return DriverManager.getConnection(Infomation.URL, Infomation.USERNAME, Infomation.PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("Conn getConn fail!",e);
		}
	}
	
	
	public static void close(java.sql.Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Connection close error !",e);
		} 
	}
	
	
	public static void close(ResultSet rs, java.sql.Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			close(conn);
		} catch (SQLException e) {
			throw new RuntimeException("Connection and ResultSet close error !",e);
		}
	}
	
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("ResultSet close error !",e);
		}
	}
	
	
}
