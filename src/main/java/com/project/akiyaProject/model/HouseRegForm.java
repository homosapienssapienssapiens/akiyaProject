package com.project.akiyaProject.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.CityEnum;

import lombok.Data;

@Data
public class HouseRegForm {
	@NotNull
	private CityEnum city;
	@NotNull
	private String address;
	@NotNull
	private Long price;
	private String completed;
	@NotNull
	private Long floor;
	@NotNull
	private Long housesize;
	private List<String> condition;
}
