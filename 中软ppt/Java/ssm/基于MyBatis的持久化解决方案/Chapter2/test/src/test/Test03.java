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
public class Test03 {

	public static void main(String[] args) {

		/*
	    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	    SecondTitleMapper sdao = sqlSession.getMapper(SecondTitleMapper.class);
	    FirstTitleMapper fdao = sqlSession.getMapper(FirstTitleMapper.class);
	    
	    FirstTitle ft1 = fdao.selectFirstTitleById(1);
	    FirstTitle ft2 = fdao.selectFirstTitleById(1);
	    System.out.println(ft1==ft2);
	    */
		
		SqlSession sqlSession1 = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		FirstTitleMapper fdao1 = sqlSession1.getMapper(FirstTitleMapper.class);
		SqlSession sqlSession2 = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		FirstTitleMapper fdao2 = sqlSession2.getMapper(FirstTitleMapper.class);
		SqlSession sqlSession3 = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		FirstTitleMapper fdao3 = sqlSession3.getMapper(FirstTitleMapper.class);
		
		FirstTitle ft1 = fdao1.selectFirstTitleById(1);
		sqlSession1.close();
	    FirstTitle ft2 = fdao2.selectFirstTitleById(1);
	    ft2.setTitleName("aaaaaa");
	    fdao2.updateFirstTitle(ft2);
	    sqlSession2.commit();
	    FirstTitle ft3 = fdao3.selectFirstTitleById(1);
	    
	}
}
