package test;

import java.util.List;

import entity.FirstTitle;
import dao.FirstTitleDao;

public class Test {

	public static void main(String[] args) {
		FirstTitleDao dao = new FirstTitleDao();
		/*
		FirstTitle ft = dao.selectFirstTitleById(1);
		System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		*/
		/*
		List<FirstTitle> list = dao.selectFirstTitleAll();
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
		*/
		
		FirstTitle ftParam = new FirstTitle();
		ftParam.setTitleName("玩玩");
		ftParam.setCreator("说说");
		ftParam.setCreateTime("2017-3-13");
		List<FirstTitle> list = dao.selectFirstTitleByAll(ftParam);
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
	}
}
