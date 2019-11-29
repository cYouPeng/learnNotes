package dao;

import java.util.List;

import entity.Dept;
import entity.Dept1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptDao d = new DeptDao();
//		Dept dp = d.getDeptById(30);
//		System.out.println(dp.getDeptno()+"  "+dp.getDname()+"   "+dp.getLoc());
//		List<Dept> list = d.getDepts();
//		for(Dept dp : list){
//			System.out.println(dp.getDeptno()+"\t"+dp.getDname()+"\t"+dp.getLoc());
//		}
//		System.out.println(d.insertDept(new Dept(34,"student","changtu"))+"行已被添加");
//		System.out.println(d.deleteDeptById(34));
		
		System.out.println(d.updateDept(new Dept(55,"pred","obama")));
	}

}
