package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.SqlSessionFactoryUtil;

import entity.FirstTitle;
import entity.Orders;
import entity.Products;
import entity.SecondTitle;
import mapper.FirstTitleMapper;
import mapper.SecondTitleMapper;
import mapper.OrdersMapper;
import mapper.ProductsMapper;

/*
 * 延迟加载
 */
public class Test02 {

	public static void main(String[] args) {

	    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	    SecondTitleMapper sdao = sqlSession.getMapper(SecondTitleMapper.class);
	    FirstTitleMapper fdao = sqlSession.getMapper(FirstTitleMapper.class);
	    
	    
	    
	    List<SecondTitle> list = sdao.selectSecondTitleAllByLazy();
	    for(SecondTitle st : list){
	    	System.out.println(st.getSid() + "\t" + st.getTitleName() + "\t" + st.getCreator() + "\t" + st.getCreateTime() + "\t" + st.getParentTitleId()); 
	    	FirstTitle ft = st.getFt();
	    	System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
	    }
	    
	    /*
	    List<FirstTitle> list = fdao.selectFirstTitleAllByLazy();
	    for(FirstTitle ft : list){
	    	System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
	    	List<SecondTitle> slist = ft.getStList();
	    	for(SecondTitle st : slist){
		    	System.out.println(st.getSid() + "\t" + st.getTitleName() + "\t" + st.getCreator() + "\t" + st.getCreateTime() + "\t" + st.getParentTitleId()); 
		    }
	    }
	    */
	    
	}
}
