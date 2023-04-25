package com.project.akiyaProject.repository;

import org.apache.ibatis.annotations.Mapper;

import com.project.akiyaProject.model.HouseInfo;
@Mapper
public interface BoardMapper {

	void mreigster();
	HouseInfo getHouseById(String house_id);
	
}
