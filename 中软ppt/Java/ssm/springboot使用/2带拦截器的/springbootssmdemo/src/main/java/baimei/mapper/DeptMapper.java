package baimei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import baimei.domain.Dept;

@Mapper
public interface DeptMapper {
  public List<Dept> getall();
}
