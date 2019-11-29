package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("empno,ename,job,mgr,hiredate,sal,comm,deptno");
		int id = 1002;
		String name = "lisi";
		String job = "clerk";
		int mid = 7566;
		String date = "2018-11-15";
		double sal = 8000;
		Double comm = 800.0;
		int did = 20;
		
//		String sql  = "insert into emp values ("+id+",'"+name+"','"+job+"',"+mid+",to_date('"+date+"','yyyy-mm-dd'),"+sal+",null,"+did+")";
//		System.out.println(sql);
		String sql  = "insert into emp values (?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "orcl");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, job);
			stmt.setInt(4, mid);
			stmt.setString(5, date);
			stmt.setDouble(6, sal);
			if(comm==null){
				stmt.setNull(7, 0);
			}else{
				stmt.setDouble(7,comm);
			}
			stmt.setInt(8, did);
			int num = stmt.executeUpdate();
			System.out.println(num);
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
