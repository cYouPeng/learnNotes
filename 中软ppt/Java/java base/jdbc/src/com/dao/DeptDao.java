package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Dept;

//每一个表都对应一个Dao类，内部包含对表操作(CUDR)的方法
public class DeptDao extends BaseDao{
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * 按照主键值（部门编号）查询单个的部门信息
	 * @param id 部门编号
	 * @return 如果部门编号存在返回该部门对象，否则返回null
	 */
	public Dept getDeptById(int id){
		String sql = "select * from dept where deptno = ?";
		try {
			conn = super.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				int did = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				return new Dept(did, dname, loc);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			super.closeAll(conn, stmt, rs);
		}
	}
	/**
	 * 查询所有的部门信息
	 * @return 包含所有部门对象的集合，该集合为部门泛型
	 */
	public List<Dept> getDepts(){
		String sql = "select * from dept order by deptno asc";
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = super.getConn();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int did = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept d = new Dept(did, dname, loc);
				list.add(d);
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
	/**
	 * 添加部门信息
	 * @param d 被添加的部门
	 * @return 1:添加成功 -1：添加失败
	 */
	public int insertDept(Dept d){
		String sql = "insert into dept values(?,?,?)";
		try {
			conn = super.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, d.getDeptno());
			stmt.setString(2, d.getDname());
			stmt.setString(3, d.getLoc());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			super.closeAll(conn, stmt, rs);
		}
	}
	/**
	 * 按照部门编号删除制定的部门
	 * @param id 被删除的部门的编号
	 * @return 1:成功删除，0：部门不存在，-1：删除失败
	 */
	public int deleteDeptById(int id){
		return 1;
	}
	/**
	 * 修改部门信息，其中部门编号被封装到参数的deptno属性
	 * @param d 部门信息的新值封装的对象
	 * @return 1:成功修改，0：部门不存在，-1：修改失败
	 */
	public int updateDept(Dept d){
		return 1;
	}
}
