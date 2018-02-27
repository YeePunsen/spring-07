package com.neuedu.until;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.bean.Column;
import com.neuedu.bean.RowMap;

public class jdbcUntil {
	static final String driver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://192.168.133.130:3306/db1?useUnicode=true&characterEncoding=utf8";
	static final String user="root";
	static final String password="123456789";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


	public static void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null)
			rs.close();
			if(pstmt!=null)
			pstmt.close();
			if(con!=null)
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int executeUpdate(String sql,Object... params) {
		int result = 0;
		Connection con = getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);	
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con,pstmt,null);
		}
		return result;
	}

	public static<T> List<T> executeQuery(String sql,RowMap<T> rowMap, Object...parmas){
		List<T> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			if(parmas!=null) {
				for(int i=0;i<parmas.length;i++) {
					pstmt.setObject(i+1, parmas[i]);
				}
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				T t = rowMap.rowMapping(rs);
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		return list;
	}
	
	public static<T> List<T> executeQuery(String sql,Class<T> clz, Object...parmas){
		List<T> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			if(parmas!=null) {
				for(int i=0;i<parmas.length;i++) {
					pstmt.setObject(i+1, parmas[i]);
				}
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//创建一个class实体对象
				T t = clz.newInstance();
				//获取对象下的属性
				Field[] fields = clz.getDeclaredFields();
				//赋值
				for (Field field : fields) {
					//获取注解
					Column c =field.getAnnotation(Column.class);
					//定义字段名
					String column=c==null?field.getName():c.value();
					//判断有没有属性
					if(check(rs,column)) {
						//打开权限
						field.setAccessible(true);
						//值
						field.set(t, rs.getObject(column));
					}
					
				}
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		return list;
	}
	public static boolean check(ResultSet rs,String column) {
		boolean result= true;
		try {
			int i = rs.findColumn(column);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
		}
		return result;
	}
}
