package com.chinasoft.news.mapper;

import java.util.List;

import com.chinasoft.news.entity.FirstTitle;

public interface IFirstTitleMapper {

	public List selectFirstTitleAll();
	public int insertFirstTitle(FirstTitle ft);
	public FirstTitle selectFirstTitleById(int fid);
	public int updateFirstTitle(FirstTitle ft);
	public int deleteFirstTitleById(int fid);
}
