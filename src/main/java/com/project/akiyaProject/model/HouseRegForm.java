package com.project.akiyaProject.model;

import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.BooleanEnum;
import com.project.akiyaProject.model.Enum.CityEnum;

import lombok.Data;

@Data
public class HouseRegForm {
	private String house_id;
	@NotNull
	private CityEnum city;
	@NotNull
	private String address;
	@NotNull
	private Long price;
	@NotNull
	private String completed;
	@NotNull
	private Long floor;
	@NotNull
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
