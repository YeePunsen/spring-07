package com.neuedu.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {

	static final String url="jdbc:mysql://192.168.133.130:3306/db1?useUnicode=true&characterEncoding=utf8";
	static final String user="root";
	static final String password="123456789";
	private Connection con ;
	
	public  void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int executeUpdate(String sql,Object[] params) {
		PreparedStatement ps = null;
		int result = 0;
		openConnection();
		try {
			ps = con.prepareStatement(sql);
			if(params!=null && params.length>0) {
				for(int i=0;i<params.length;i++) {
					
						ps.setObject(i+1, params[i]);
					} 
				result = ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
