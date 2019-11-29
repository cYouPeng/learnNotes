package com.chinasoft.news.mapper;

import java.util.List;

import com.chinasoft.news.entity.SecondTitle;

public interface ISecondTitleMapper {

	public List selectSecondTitleByFid(int fid);
	public SecondTitle selectSecondTitleById(int sid);
	public List selectSecondTitleAll();
	public List selectSecondTitleAllByLazy();
	public int insertSecondTitle(SecondTitle st);
	public int updateSecondTitle(SecondTitle st);
	public int deleteSecondTitleByFid(int fid);
	public int deleteSecondTitleById(int sid);
}
