package com.project.akiyaProject.model;

import com.project.akiyaProject.model.Enum.ConditionEnum;
import com.project.akiyaProject.model.Enum.CityEnum;

import lombok.Data;
@Data
public class HouseInfo {
	private String house_id;
	private CityEnum city;
	private String address;
	private Long price;
	private String completed;
	private Long floor;
	private Long housesize;
	private ConditionEnum bus;
	private ConditionEnum subway; 
	private ConditionEnum convini;
	private ConditionEnum hospital;
	private ConditionEnum aircon;
	private ConditionEnum bathroom;
	private ConditionEnum parking;
	private ConditionEnum washer;
	private ConditionEnum pet;
	private ConditionEnum autolock;
}
