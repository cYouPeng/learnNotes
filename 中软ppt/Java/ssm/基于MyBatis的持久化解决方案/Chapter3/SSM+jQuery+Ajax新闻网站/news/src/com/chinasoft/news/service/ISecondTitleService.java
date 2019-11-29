package com.chinasoft.news.service;

import java.util.List;

import com.chinasoft.news.entity.SecondTitle;

public interface ISecondTitleService {

	public List selectSecondTitleByFid(int fid);
	public SecondTitle selectSecondTitleById(int sid);
	public List selectSecondTitleAll();
	public int insertSecondTitle(SecondTitle st);
	public int updateSecondTitle(SecondTitle st);
	public int deleteSecondTitleByFid(int fid);
	public int deleteSecondTitleById(int sid);
}
