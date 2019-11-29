
import java.sql.SQLException;

import com.dao.BaseDao;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		BaseDao dao = new BaseDao();
		try {
			dao.getConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
