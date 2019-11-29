package baimei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import baimei.domain.Dept;
import baimei.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@RequestMapping("/test")
	public String test1() {

		return "dept hello";

	}

	public DeptService getService() {
		return service;
	}

	public void setService(DeptService service) {
		this.service = service;
	}
	@RequestMapping("/test1")
	@ResponseBody
	public List<Dept> getall(){
		return this.service.getAll();
	}
	
	
}
