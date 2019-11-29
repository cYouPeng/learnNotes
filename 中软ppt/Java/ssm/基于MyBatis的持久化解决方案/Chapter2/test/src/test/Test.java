package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.SqlSessionFactoryUtil;

import entity.FirstTitle;
import mapper.FirstTitleMapper;

public class Test {

	public static void main(String[] args) {

	    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	    FirstTitleMapper dao = sqlSession.getMapper(FirstTitleMapper.class);
	    
	    FirstTitle ft = dao.selectFirstTitleById(1);
	    System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		
	    /*
	    List<FirstTitle> list = dao.selectFirstTitleAll();
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
		*/
	    /*
	    FirstTitle ftParam = new FirstTitle();
		ftParam.setTitleName("玩玩");
		ftParam.setCreator("说说");
		ftParam.setCreateTime("2017-3-13");
		List<FirstTitle> list = dao.selectFirstTitleByAll(ftParam);
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
		*/
	    /*
	    List<FirstTitle> list = dao.selectFirstTitleByLike("%g%");
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
		*/
	    /*
	    FirstTitle ftParam = new FirstTitle();
		//ftParam.setTitleName("%g%");
		//ftParam.setCreator("%管%");
		//ftParam.setCreateTime("%2017%");
		List<FirstTitle> list = dao.selectFirstTitleByLikeAll(ftParam);
		for(FirstTitle ft : list){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
		*/
	    /*
	    FirstTitle ftParam = new FirstTitle();
		ftParam.setTitleName("安安");
		ftParam.setCreator("嘿嘿");
		ftParam.setCreateTime("2017-4-12");
		dao.insertFirstTitle(ftParam);
		sqlSession.commit();
		System.out.println(ftParam.getFid());
		*/
	    /*
	    FirstTitle ftParam = new FirstTitle();
	    ftParam.setFid(7);
		ftParam.setTitleName("安安11");
		ftParam.setCreator("嘿嘿11");
		ftParam.setCreateTime("2017-4-12");
		dao.updateFirstTitle(ftParam);
		sqlSession.commit();
		*/
	    /*
	    dao.deleteFirstTitleById(7);
	    sqlSession.commit();
	    */
	    /*
	    int result = dao.selectFirstTitleByCount();
	    System.out.println(result);
	    */
	}
}
