package com.chinasoft.news.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.service.FirstTitleService;
import com.chinasoft.news.service.SecondTitleService;

@Controller
@RequestMapping("/firstTitle")
public class FirstTitleController {
	
	@Resource
	private FirstTitleService firstTitleService;
	@Resource
	private SecondTitleService secondTitleService;
	
	@RequestMapping("/selectFirstTitleAll")
	public String selectFirstTitleAll(Model model){
		List fList = firstTitleService.selectFirstTitleAll();
		model.addAttribute("fList", fList);
    	return "index";
	}
	
	@RequestMapping("/selectFirstTitleAllAdmin")
	public String selectFirstTitleAllAdmin(Model model){
		List fList = firstTitleService.selectFirstTitleAll();
		model.addAttribute("fList", fList);
    	return "admin/firstList";
	}
	
	@RequestMapping("/insertFirstTitleAdmin")
	public String insertFirstTitleAdmin(FirstTitle ft){
		int result = firstTitleService.insertFirstTitle(ft);
		if(result>0){
			return "redirect:/firstTitle/selectFirstTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}
	
	@RequestMapping("/selectFirstTitleByIdAdmin")
	public String selectFirstTitleByIdAdmin(int fid,Model model){
		FirstTitle ft = firstTitleService.selectFirstTitleById(fid);
		model.addAttribute("ft", ft);
    	return "admin/updateFirst";
	}
	
	@RequestMapping("/updateFirstTitleAdmin")
	public String updateFirstTitleAdmin(FirstTitle ft){
		int result = firstTitleService.updateFirstTitle(ft);
		if(result>0){
			return "redirect:/firstTitle/selectFirstTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}
	
	@RequestMapping("/deleteFirstTitleAdmin")
	public String deleteFirstTitleAdmin(int fid){
		int result = firstTitleService.deleteFirstTitle(fid);
		//mybatis不支持级联删除，所以要自己手动删除。
		secondTitleService.deleteSecondTitleByPid(fid);
		if(result>0){
			return "redirect:/firstTitle/selectFirstTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}

}
