package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Dept;
import com.entity.Emp;

public class EmpDao extends BaseDao{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public List<Emp> getEmps(){
		String sql = "select e.empno,e.ename,e.job,e.mgr,e.hiredate,e.sal,e.comm,d.deptno,d.dname,d.loc"
				+ " from emp e, dept d"
				+ " where e.deptno = d.deptno";
		List<Emp> list = new ArrayList<Emp>();
		try {
			conn = super.getConn();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				Integer mgr = null;
				if(rs.getObject("mgr")!=null){
					mgr = rs.getInt("mgr");
				}
				java.sql.Date d = rs.getDate("hiredate");//rs.getTimestamp("hiredate")
				double sal = rs.getDouble("sal");
				Double comm = null;
				if(rs.getObject("comm")!=null){
					comm  = rs.getDouble("comm");
				}
				int did = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept dept = new Dept(did, dname, loc);
				Emp emp = new Emp(id, name, job, mgr, d, sal, comm, dept);
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			super.closeAll(conn, stmt, rs);
		}
		
	}
//	public int insertEmp(Emp e){
//		
//	}
}
