package com.chinasoft.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.news.entity.SecondTitle;
import com.chinasoft.news.mapper.ISecondTitleMapper;
import com.chinasoft.news.util.CommonInfo;

@Service
public class SecondTitleServiceImpl implements ISecondTitleService{
	
	@Autowired
	private ISecondTitleMapper secondTitleMapper;

	@Override
	public List selectSecondTitleByFid(int fid) {
		return secondTitleMapper.selectSecondTitleByFid(fid);
	}
	
	public SecondTitle selectSecondTitleById(int sid){
		return secondTitleMapper.selectSecondTitleById(sid);
	}
	
	public List selectSecondTitleAll(){
		//return secondTitleMapper.selectSecondTitleAll();
		return secondTitleMapper.selectSecondTitleAllByLazy();
	}
	 
	public int insertSecondTitle(SecondTitle st){
		st.setCreateTime(CommonInfo.getDate());
		return secondTitleMapper.insertSecondTitle(st);
	}
	
	public int updateSecondTitle(SecondTitle st){
		st.setCreateTime(CommonInfo.getDate());
		return secondTitleMapper.updateSecondTitle(st);
	}
	
	public int deleteSecondTitleByFid(int fid){
		return secondTitleMapper.deleteSecondTitleByFid(fid);
	}
	
	public int deleteSecondTitleById(int sid){
		return secondTitleMapper.deleteSecondTitleById(sid);
	}
}
