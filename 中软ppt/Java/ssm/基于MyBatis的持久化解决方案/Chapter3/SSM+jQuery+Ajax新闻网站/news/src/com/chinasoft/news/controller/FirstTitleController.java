package com.chinasoft.news.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.service.IFirstTitleService;
import com.chinasoft.news.service.ISecondTitleService;

@Controller
@RequestMapping("/ft")
public class FirstTitleController {
	
	//@Resource()
	@Autowired
	private IFirstTitleService firstTitleService;
	@Autowired
	private ISecondTitleService secondTitleService;


	@ResponseBody
	@RequestMapping("/selectFirstTitleAll.do")
	public List selectFirstTitleAll() throws Exception {
		return firstTitleService.selectFirstTitleAll();
	}
	
	@ResponseBody
	@RequestMapping("/selectFirstTitleById.do")
	public FirstTitle selectFirstTitleById(int fid) throws Exception {
		return firstTitleService.selectFirstTitleById(fid);
	}
	
	@ResponseBody
	@RequestMapping("/insertFirstTitle.do")
	public int insertFirstTitle(FirstTitle ft) throws Exception {
		return firstTitleService.insertFirstTitle(ft);
	}
	
	@ResponseBody
	@RequestMapping("/updateFirstTitle.do")
	public int updateFirstTitle(FirstTitle ft) throws Exception {
		return firstTitleService.updateFirstTitle(ft);
	}
	
	@ResponseBody
	@RequestMapping("/deleteFirstTitleById.do")
	public int deleteFirstTitleById(int fid) throws Exception {
		secondTitleService.deleteSecondTitleByFid(fid);
		return firstTitleService.deleteFirstTitleById(fid);
	}
}
