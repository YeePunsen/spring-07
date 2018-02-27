package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.until.JdbcUtil;

public class Students {

	static final String url="jdbc:mysql://192.168.133.130:3306/db1?useUnicode=true&characterEncoding=utf8";
	static final String user="root";
	static final String password="123456789";
	
	public static void main(String[] args) {
		Stu stu = new Stu("kim",2,1);
		//Student(stu);
		Stu(stu);
	}		
	public static void Stu(Stu stu) {
		JdbcUtil jdbcutil = new JdbcUtil();
		String sql = "insert into student (name,b_id,gerden) values(?,?,?)";
		Object[] params= {stu.getName(),stu.getBId(),stu.getGerden() };
		int i =jdbcutil.executeUpdate(sql, params);
		System.out.println("受影响行数为："+i);
	}
	
	public static void Student(Stu stu) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		    String sql_insert="insert into student (name,b_id,gerden) values(?,?,?)";
		    ps = con.prepareStatement(sql_insert);
		    ps.setString(1, stu.getName());
		    ps.setInt(2, stu.getBId());
		    ps.setInt(3, stu.getGerden());
		    int affectRows = ps.executeUpdate();
		    System.out.println("受影响的行数"+ affectRows );
		    //String sql="select * from student";
			
		   // ResultSet rs = stmt.executeQuery(sql);
			//while(rs.next()) {
				//System.out.println("ID:"+rs.getInt("id")+"NAME:" + rs.getString(2)+"BID:"+rs.getInt("b_id")+"GERDEN:"+rs.getInt(4));//可以采用别名或index		
				
			//}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
	}

	
}	
