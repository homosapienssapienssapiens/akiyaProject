package com.project.akiyaProject.model;

import com.project.akiyaProject.model.Enum.BooleanEnum;

import lombok.Data;
@Data
public class HouseInfo {
	private String house_id;
	private String city;
	private String address;
	private Long price;
	private String completed;
	private Long floor;
	private Long housesize;
	private BooleanEnum bus;
	private BooleanEnum subway; 
	private BooleanEnum convini;
	private BooleanEnum hospital;
	private BooleanEnum aircon;
	private BooleanEnum bathroom;
	private BooleanEnum parking;
	private BooleanEnum washer;
	private BooleanEnum pet;
	private BooleanEnum autolock;
}
