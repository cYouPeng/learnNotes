package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnjoyDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List getEnjoyListByUser(String userId){
		String sql = "select * from t_enjoy where userid = ? order by id desc";
		List list = new ArrayList();
		
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			while(rs.next()){
				Map val = new HashMap();
				val.put("id", rs.getInt("id"));
				val.put("objectId", rs.getString("objId"));
				list.add(val);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public int addEnjoy(String objId,String userId){
		String sql = "insert into t_enjoy values(null,?,?)";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.setString(2, objId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public int delEnjoy(String objId,String userId){
		String sql = "delete from t_enjoy where userId=? and objId=?";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.setString(2, objId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
}
