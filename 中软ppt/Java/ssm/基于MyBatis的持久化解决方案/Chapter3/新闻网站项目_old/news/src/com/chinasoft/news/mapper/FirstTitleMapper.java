package com.chinasoft.news.mapper;

import java.util.List;

import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.entity.Users;

public interface FirstTitleMapper {

	public List selectFirstTitleAll();
	public int insertFirstTitle(FirstTitle ft);
	public FirstTitle selectFirstTitleById(int fid);
	public int updateFirstTitle(FirstTitle ft);
	public int deleteFirstTitle(int fid);
}
