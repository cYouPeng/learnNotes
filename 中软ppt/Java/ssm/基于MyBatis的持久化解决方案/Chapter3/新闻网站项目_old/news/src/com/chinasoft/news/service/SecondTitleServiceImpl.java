package com.chinasoft.news.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.news.common.NewsCommon;
import com.chinasoft.news.entity.SecondTitle;
import com.chinasoft.news.mapper.SecondTitleMapper;

@Service
@Transactional  
public class SecondTitleServiceImpl implements SecondTitleService{

	@Resource
	private SecondTitleMapper secondTitleMapper;

	@Override
	public List selectSecondTitleByFid(int fid) {
		return secondTitleMapper.selectSecondTitleByFid(fid);
	}
	
	public SecondTitle selectSecondTitleById(int sid){
		return secondTitleMapper.selectSecondTitleById(sid);
	}
	
	public int deleteSecondTitleByPid(int fid){
		return secondTitleMapper.deleteSecondTitleByPid(fid);
	}
	
	public List selectSecondTitleAll(){
		return secondTitleMapper.selectSecondTitleAll();
	}
	
	public int insertSecondTitle(SecondTitle st){
		st.setCreateTime(NewsCommon.getDate());
		return secondTitleMapper.insertSecondTitle(st);
	}
	
	public int updateSecondTitle(SecondTitle st){
		st.setCreateTime(NewsCommon.getDate());
		return secondTitleMapper.updateSecondTitle(st);
	}
	
	public int deleteSecondTitle(int sid){
		return secondTitleMapper.deleteSecondTitle(sid);
	}
}
