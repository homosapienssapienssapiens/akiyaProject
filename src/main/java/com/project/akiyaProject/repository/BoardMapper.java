package com.project.akiyaProject.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.akiyaProject.model.FindConditionForm;
import com.project.akiyaProject.model.HouseInfo;
@Mapper
public interface BoardMapper {

	void houseReigster();
	List<HouseInfo> houseList(FindConditionForm con);
	HouseInfo getHouseById(String house_id);
}
