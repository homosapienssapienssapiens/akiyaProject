package com.project.akiyaProject.repository;

import com.project.akiyaProject.model.HouseInfo;

public interface BoardMapper {

	void mreigster();
	HouseInfo getHouseById(String house_id);
	
}
