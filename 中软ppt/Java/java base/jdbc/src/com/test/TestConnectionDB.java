package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//获取数据库的连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","orcl");
			System.out.println("connection ok");
			//用连接对象创建Statement对象
			Statement stmt = conn.createStatement();
			
			int num = stmt.executeUpdate("delete from dept where deptno=50");
			System.out.println(num+"行被删除");
//			//statement对象将查询的sql发送至数据库，并得到数据库返回的结果集
//			ResultSet rs = stmt.executeQuery("select loc,deptno,dname from dept");
//			//遍历结果集
//			while(rs.next()){//rs.next()判断结果集中是否有下一行，如果有返回true并指向下一行，如果没有返回false
//				String addr = rs.getString("loc");
//				int id = rs.getInt("deptno");
//				String name = rs.getString("dname");
//				
////				int id = rs.getInt(1);//
////				String name = rs.getString(2);
////				String addr = rs.getString(3);
//				System.out.println(id+"\t"+name+"\t"+addr);
//			}
//			rs.close();
			stmt.close();
			conn.close();
			System.out.println("close connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
