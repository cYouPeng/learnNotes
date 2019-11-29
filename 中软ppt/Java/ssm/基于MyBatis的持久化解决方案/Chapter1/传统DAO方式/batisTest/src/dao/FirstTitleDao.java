package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.FirstTitle;

import util.SqlSessionFactoryUtil;

public class FirstTitleDao {

	public FirstTitle selectFirstTitleById(int fid){
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		return sqlSession.selectOne("ft.selectFirstTitleById",1);
	}
	
	public List selectFirstTitleAll(){
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		return sqlSession.selectList("ft.selectFirstTitleAll");
	}
	
	public List selectFirstTitleByAll(FirstTitle ft){
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		return sqlSession.selectList("ft.selectFirstTitleByAll",ft);
	}
}
