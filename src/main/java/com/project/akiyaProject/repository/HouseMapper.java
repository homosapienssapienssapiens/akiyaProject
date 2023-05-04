package com.project.akiyaProject.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.akiyaProject.model.FindConditionForm;
import com.project.akiyaProject.model.HouseInfo;
@Mapper
public interface HouseMapper {

	void saveHouseInfo(HouseInfo houseInfo);
	List<HouseInfo> getHouseByCondition(FindConditionForm con);
	List<HouseInfo> getAllHouseList();
	HouseInfo getHouseById(String house_id);

}
