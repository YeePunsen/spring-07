package com.neuedu.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.until.jdbcUntil;

public class studentDao {
//	String url="jdbc:mysql://192.168.133.130:3306/db1?useUnicode=true&characterEncoding=utf8";
//	String user="root";
//	String password="123456789";
	
	public List<Student> getStudents(){
		return jdbcUntil.executeQuery("select id,name,b_id,gerden from student", new RowMap<Student>() {

			@Override
			public Student rowMapping(ResultSet rs) {
				// TODO Auto-generated method stub
				Student student = new Student();
				try {
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
			        student.setBId(rs.getInt("b_id"));
					student.setGerden(rs.getInt("gerden"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return student;
			}
			
		}, null);
//		Connection con=jdbcUntil.getConnection();
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		List<Student> students=new ArrayList<>();
//		//��������
//		try {
////			Class.forName("com.mysql.jdbc.Driver");
////		//��������
////			con = DriverManager.getConnection(url,user,password);
//		//���������
//			pstmt = con.prepareStatement("select id,name,b_id,gerden from student");
//		//ִ��sql���
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Student student = new Student();
//				student.setId(rs.getInt("id"));
//				student.setName(rs.getString("name"));
//				student.setBId(rs.getInt("b_id"));
//				student.setGerden(rs.getInt("gerden"));
//				students.add(student);
//			}
//		}catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//		}  finally {
//			jdbcUntil.close(con, pstmt, rs);
//		}
//		return students;
	}

	public int add(Student student) {
		
	int	result = jdbcUntil.executeUpdate("insert into student (name,b_id,gerden) values(?,?,?)", student.getName(),student.getBId(),student.getGerden());
		return result;
		//		Connection con=jdbcUntil.getConnection();
//		PreparedStatement pstmt=null;
//		int result = 0;
//		//��������
//		try {
//		//���������
//			pstmt = con.prepareStatement("insert into student (name,b_id,gerden) values(?,?,?)");
//		//ע�����
//			pstmt.setString(1, student.getName());
//			pstmt.setInt(2, student.getBId());
//			pstmt.setInt(3, student.getGerden());
//		//ִ��sql���
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//		}  finally {
//			
//			jdbcUntil.close(con, pstmt, null);
//		}
//		
//		return result;
	}

    public int update(Student student) {
    	int	result = jdbcUntil.executeUpdate("update student set name=?,b_id=?,gerden=? where id=?", student.getName(),student.getBId(),student.getGerden(),student.getId());
		return result;
//    	Connection con = jdbcUntil.getConnection();
//    	PreparedStatement pstmt = null;
//    	int result = 0;
//    	//��������
//    	try {
//		
//			
//		//���������
//			pstmt = con.prepareStatement("update student set name=?,b_id=?,gerden=? where id=?");	
//		//ע�����
//			pstmt.setString(1, student.getName());
//			pstmt.setInt(2, student.getBId());
//			pstmt.setInt(3, student.getGerden());
//			pstmt.setInt(4, student.getId());
//		//ִ��sql���	
//			result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//		} finally {
//			
//			jdbcUntil.close(con, pstmt, null);
//		}
//    	return result;
    }

    public int delete(int id) {
    	int	result = jdbcUntil.executeUpdate("delete from student where id=?", id);
		return result;
//    	Connection con=jdbcUntil.getConnection();
//    	PreparedStatement pstmt=null;
//    	int result = 0;
//    	//��������
//    	try {
//		
//		//���������
//			pstmt = con.prepareStatement("delete from student where id=?");
//		//ע�����
//			pstmt.setInt(1,id);
//		//ִ��sql���
//			result=pstmt.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//		} finally {
//			
//			jdbcUntil.close(con, pstmt, null);
//		}
//    	return result;
    }
}
