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
 * 关联查询
 */
public class Test01 {

	public static void main(String[] args) {

	    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	    SecondTitleMapper sdao = sqlSession.getMapper(SecondTitleMapper.class);
	    FirstTitleMapper fdao = sqlSession.getMapper(FirstTitleMapper.class);
	    OrdersMapper odao = sqlSession.getMapper(OrdersMapper.class);
	    ProductsMapper pdao = sqlSession.getMapper(ProductsMapper.class);
	    
	    /*
	    List<SecondTitle> list = sdao.selectSecondTitleAll();
	    for(SecondTitle st : list){
	    	System.out.println(st.getSid() + "\t" + st.getTitleName() + "\t" + st.getCreator() + "\t" + st.getCreateTime() + "\t" + st.getParentTitleId() + "\t" + st.getFt().getTitleName()); 
	    }
	    */
	    /*
	    List<FirstTitle> list = fdao.selectFirstTitleAll();
	    for(FirstTitle ft : list){
	    	System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
	    	List<SecondTitle> slist = ft.getStList();
	    	for(SecondTitle st : slist){
		    	System.out.println(st.getSid() + "\t" + st.getTitleName() + "\t" + st.getCreator() + "\t" + st.getCreateTime() + "\t" + st.getParentTitleId()); 
		    }
	    }
	    */
	    
	    FirstTitle ft = fdao.selectFirstTitleById(1);
	    System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
	    List<SecondTitle> slist = ft.getStList();
	    for(SecondTitle st : slist){
		    System.out.println(st.getSid() + "\t" + st.getTitleName() + "\t" + st.getCreator() + "\t" + st.getCreateTime() + "\t" + st.getParentTitleId()); 
		}
		
	    /*
	    List<Orders> olist = odao.selectOrdersAll();
	    for(Orders o : olist){
	    	System.out.println(o.getOid() + "\t" + o.getUserId() + "\t" + o.getCreateTime());
	    	List<Products> plist = o.getProductsList();
	    	for(Products p : plist){
		    	System.out.println(p.getPid() + "\t" + p.getProductName() + "\t" + p.getProductPrice()); 
		    }
	    }
	    */
	    /*
	    List<Products> plist = pdao.selectProductsAll();
	    for(Products p : plist){
	    	System.out.println(p.getPid() + "\t" + p.getProductName() + "\t" + p.getProductPrice()); 
	    	List<Orders> olist = p.getOrdersList();
	    	for(Orders o : olist){
	    		System.out.println(o.getOid() + "\t" + o.getUserId() + "\t" + o.getCreateTime());
		    }
	    }
	    */
	}
}
