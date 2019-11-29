package com.chinasoft.news.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.news.common.NewsCommon;
import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.mapper.FirstTitleMapper;
import java.util.Date;
import java.text.SimpleDateFormat;

@Service
@Transactional  
public class FirstTitleServiceImpl implements FirstTitleService{

	@Resource
	private FirstTitleMapper firstTitleMapper;

	@Override
	public List selectFirstTitleAll() {
		return firstTitleMapper.selectFirstTitleAll();
	}
	
	public int insertFirstTitle(FirstTitle ft){
		ft.setCreateTime(NewsCommon.getDate());
		return firstTitleMapper.insertFirstTitle(ft);
	}
	
	public FirstTitle selectFirstTitleById(int fid){
		return firstTitleMapper.selectFirstTitleById(fid);
	}
	
	public int updateFirstTitle(FirstTitle ft){
		ft.setCreateTime(NewsCommon.getDate());
		return firstTitleMapper.updateFirstTitle(ft);
	}
	
	public int deleteFirstTitle(int fid){
		return firstTitleMapper.deleteFirstTitle(fid);
	}
}
