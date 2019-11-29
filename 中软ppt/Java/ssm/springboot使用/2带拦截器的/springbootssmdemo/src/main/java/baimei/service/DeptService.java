package baimei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baimei.domain.Dept;
import baimei.mapper.DeptMapper;

@Service
public class DeptService {
	@Autowired
	private DeptMapper mapper;

	public DeptMapper getMapper() {
		return mapper;
	}

	public void setMapper(DeptMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<Dept> getAll(){
		return this.mapper.getall();
	}
}
