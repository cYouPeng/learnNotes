package com.chinasoft.news.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.news.entity.SecondTitle;
import com.chinasoft.news.service.ISecondTitleService;

@Controller
@RequestMapping("/st")
public class SecondTitleController {
	
	@Autowired
	private ISecondTitleService secondTitleService;

	@ResponseBody
	@RequestMapping("/selectSecondTitleByFid.do")
	public List selectSecondTitleByFid(int fid) throws Exception {
		return secondTitleService.selectSecondTitleByFid(fid);
	}
	
	@ResponseBody
	@RequestMapping("/selectSecondTitleById.do")
	public SecondTitle selectSecondTitleById(int sid) throws Exception {
		return secondTitleService.selectSecondTitleById(sid);
	}
	
	@ResponseBody
	@RequestMapping("/selectSecondTitleAll.do")
	public List selectSecondTitleAll() throws Exception {
		return secondTitleService.selectSecondTitleAll();
	}
	
	@ResponseBody
	@RequestMapping("/insertSecondTitle.do")
	public int insertSecondTitle(SecondTitle st) throws Exception {
		return secondTitleService.insertSecondTitle(st);
	}
	
	@ResponseBody
	@RequestMapping("/updateSecondTitle.do")
	public int updateSecondTitle(SecondTitle st) throws Exception {
		return secondTitleService.updateSecondTitle(st);
	}
	
	@ResponseBody
	@RequestMapping("/deleteSecondTitleById.do")
	public int deleteSecondTitleById(int sid) throws Exception {
		return secondTitleService.deleteSecondTitleById(sid);
	}
}
