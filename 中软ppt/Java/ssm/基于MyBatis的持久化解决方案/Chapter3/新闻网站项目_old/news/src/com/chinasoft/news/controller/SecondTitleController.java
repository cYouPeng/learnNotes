package com.chinasoft.news.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chinasoft.news.entity.SecondTitle;
import com.chinasoft.news.service.SecondTitleService;
import com.chinasoft.news.service.FirstTitleService;

@Controller
@RequestMapping("/secondTitle")
public class SecondTitleController {
	
	@Resource
	private SecondTitleService secondTitleService;
	@Resource
	private FirstTitleService firstTitleService;
	
	@RequestMapping("/selectSecondTitleById")
	public String selectSecondTitleByFid(int sid,Model model){
		SecondTitle st = secondTitleService.selectSecondTitleById(sid);
		model.addAttribute("st", st);
    	return "news";
	}
	
	@RequestMapping("/selectSecondTitleByFid")
	public String selectSecondTitleById(int fid,Model model){
		List sList = secondTitleService.selectSecondTitleByFid(fid);
		model.addAttribute("sList", sList);
    	return "list";
	}
	
	@RequestMapping("/selectSecondTitleAllAdmin")
	public String selectSecondTitleAllAdmin(Model model){
		List sList = secondTitleService.selectSecondTitleAll();
		model.addAttribute("sList", sList);
    	return "admin/secondList";
	}
	
	@RequestMapping("/insertSecondTitleInitAdmin")
	public String insertSecondTitleInitAdmin(Model model){
		List fList = firstTitleService.selectFirstTitleAll();
		model.addAttribute("fList", fList);
    	return "admin/addSecond";
	}
	
	@RequestMapping("/insertSecondTitleAdmin")
	public String insertSecondTitleAdmin(SecondTitle st){
		int result = secondTitleService.insertSecondTitle(st);
		if(result>0){
			return "redirect:/secondTitle/selectSecondTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}
	
	@RequestMapping("/updateSecondTitleInitAdmin")
	public String updateSecondTitleInitAdmin(int sid,Model model){
		List fList = firstTitleService.selectFirstTitleAll();
		SecondTitle st = secondTitleService.selectSecondTitleById(sid);
		model.addAttribute("fList", fList);
		model.addAttribute("st", st);
    	return "admin/updateSecond";
	}
	
	@RequestMapping("/updateSecondTitleAdmin")
	public String updateSecondTitleAdmin(SecondTitle st,Model model){
		int result = secondTitleService.updateSecondTitle(st);
		if(result>0){
			return "redirect:/secondTitle/selectSecondTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}
	
	@RequestMapping("/deleteSecondTitleAdmin")
	public String deleteSecondTitleAdmin(int sid){
		int result = secondTitleService.deleteSecondTitle(sid);
		if(result>0){
			return "redirect:/secondTitle/selectSecondTitleAllAdmin";
		}else{
			return "admin/error";
		}
	}

}
