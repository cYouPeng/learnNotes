package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.User;

public class UserDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public int addUser(User user){
		String sql = "insert into t_user values(?,?,?,?)";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getLoginId());
			stmt.setString(2, user.getLoginPwd());
			stmt.setString(3, user.getNickName());
			stmt.setString(4, user.getHeadPic());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public User getUserById(String userId){
		String sql = "select * from t_user where loginId = ?";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			if(rs.next()){
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String pic = rs.getString(4);
				User user = new User(id, pwd, name, pic);
				return user;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public int findUserId(String userId){
		String sql = "select loginId from t_user where loginId = ?";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			if(rs.next()){
				return 1;
			}
			return 2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public int updateUser(User user){
		String temp = user.getHeadPic()!=null?",headPic='"+user.getHeadPic()+"'":"";
		//System.out.println(temp);
		String sql = "update t_user set nickName=?"+temp+" where loginId=?";
		//System.out.println(sql);
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getNickName());
			stmt.setString(2, user.getLoginId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public int updatePwd(User user){
		String sql = "update t_user set loginPwd=? where loginId=?";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getLoginPwd());
			stmt.setString(2, user.getLoginId());
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
