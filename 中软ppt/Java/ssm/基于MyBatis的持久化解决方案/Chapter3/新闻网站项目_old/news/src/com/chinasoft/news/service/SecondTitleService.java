package com.chinasoft.news.service;

import java.util.List;

import com.chinasoft.news.entity.SecondTitle;

public interface SecondTitleService {

	public List selectSecondTitleByFid(int fid);
	public SecondTitle selectSecondTitleById(int sid);
	public int deleteSecondTitleByPid(int fid);
	public List selectSecondTitleAll();
	public int insertSecondTitle(SecondTitle st);
	public int updateSecondTitle(SecondTitle st);
	public int deleteSecondTitle(int sid);
}
