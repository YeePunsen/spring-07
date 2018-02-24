package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		String url="jdbc:mysql://192.168.80.131:3306/db2";
		String user="root";
		String password="123456";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {	
			Class.forName("com.mysql.jdbc.Driver");			
		    con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement("select * from student");
		
			rs= pstmt.executeQuery();

			while(rs.next()){
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	}


