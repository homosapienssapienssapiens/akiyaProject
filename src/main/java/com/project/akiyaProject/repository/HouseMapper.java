package com.project.akiyaProject.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.akiyaProject.model.FindConditionForm;
import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.model.Member;
@Mapper
public interface HouseMapper {

	void saveHouseInfo(HouseInfo houseInfo);
	List<HouseInfo> gethouseByCondition(FindConditionForm con);
	HouseInfo getHouseById(String house_id);

}
