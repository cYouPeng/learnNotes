package com.chinasoft.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.mapper.IFirstTitleMapper;
import com.chinasoft.news.util.CommonInfo;

@Service
public class FirstTitleServiceImpl implements IFirstTitleService{
	
	@Autowired
	private IFirstTitleMapper firstTitleMapper;

	public List selectFirstTitleAll(){
		return firstTitleMapper.selectFirstTitleAll();
	}
	
	public int insertFirstTitle(FirstTitle ft){
		ft.setCreateTime(CommonInfo.getDate());
		return firstTitleMapper.insertFirstTitle(ft);
	}
	
	public FirstTitle selectFirstTitleById(int fid){
		return firstTitleMapper.selectFirstTitleById(fid);
	}
	
	public int updateFirstTitle(FirstTitle ft){
		ft.setCreateTime(CommonInfo.getDate());
		return firstTitleMapper.updateFirstTitle(ft);
	}
	
	public int deleteFirstTitleById(int fid){
		return firstTitleMapper.deleteFirstTitleById(fid);
	}

}
