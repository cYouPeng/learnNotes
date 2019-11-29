package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import entity.FirstTitle;

public class FirstTitleDaoImpl extends SqlSessionDaoSupport implements FirstTitleDao{
	
	public List selectFirstTitleAll(){
		SqlSession sqlSession = this.getSqlSession();
		List firstList = sqlSession.selectList("ft.selectFirstTitleAll");
		//不需要关闭sqlSession，spring自动管理。
		return firstList;
	}
}
