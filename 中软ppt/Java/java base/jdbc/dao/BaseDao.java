package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDao {
	//static代表独一份，甭管你子类创建多少个对象，这个属性都是唯一的，被所有对象所共享，如果不是静态的，那就是每个子类对象都有自己的该属性，浪费空间
//	private static final String DRIVER_CLASS="";
//	private static final String DB_URL="";
//	private static final String DB_NAME="";
//	private static final String DB_PWD="";
	private static final String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_NAME="scott";
	private static final String DB_PWD="orcl";
	
	protected Connection getConn() throws SQLException{
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(DB_URL,DB_NAME,DB_PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	protected void closeAll(Connection conn, Statement stmt, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
