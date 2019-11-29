package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.SqlSessionFactoryUtil;

import entity.FirstTitle;
import mapper.FirstTitleMapper;

public class Test {

	public static void main(String[] args) {

	    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	    FirstTitleMapper dao = sqlSession.getMapper(FirstTitleMapper.class);
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
	    /*
	    List list = new ArrayList();
	    FirstTitle ft1 = new FirstTitle();
		ft1.setTitleName("去去去");
		ft1.setCreator("我我我");
		ft1.setCreateTime("2017-4-12");
		FirstTitle ft2 = new FirstTitle();
		ft2.setTitleName("鹅鹅鹅");
		ft2.setCreator("热热热");
		ft2.setCreateTime("2017-4-12");
		FirstTitle ft3 = new FirstTitle();
		ft3.setTitleName("停停停");
		ft3.setCreator("哟哟哟");
		ft3.setCreateTime("2017-4-12");
		list.add(ft1);
		list.add(ft2);
		list.add(ft3);
	    int result = dao.insertFirsttitleBatch(list);
	    sqlSession.commit();
	    System.out.println(result);
	    */
	    /*
	    List list = new ArrayList();
	    FirstTitle ft1 = new FirstTitle();
	    ft1.setFid(1731);
		ft1.setTitleName("111");
		ft1.setCreator("嘿嘿01");
		ft1.setCreateTime("2017-4-12");
		FirstTitle ft2 = new FirstTitle();
		ft2.setFid(1741);
		ft2.setTitleName("222");
		ft2.setCreator("嘿嘿02");
		ft2.setCreateTime("2017-4-12");
		FirstTitle ft3 = new FirstTitle();
		ft3.setFid(1751);
		ft3.setTitleName("333");
		ft3.setCreator("嘿嘿03");
		ft3.setCreateTime("2017-4-12");
		list.add(ft1);
		list.add(ft2);
		list.add(ft3);
	    int result = dao.updateFirsttitleBatch(list);
	    sqlSession.commit();
	    System.out.println(result);
	    */
	    /*
	    int[] fids = {173,174,175};
	    int result = dao.deleteFirstTitleBatch(fids);
	    sqlSession.commit();
	    System.out.println(result);
	    */
	}
}
