import java.util.List;

import com.dao.EmpDao;
import com.entity.Emp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.Date date = new java.sql.Timestamp(1000000000000L);
//		
//		System.out.println(date);
//		
//		java.util.Date d2 = new java.util.Date();
//		Timestamp t = new Timestamp(d2.getTime());
		
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.getEmps();
		for(Emp e : list){
			System.out.println(e);
		}
	}

}
