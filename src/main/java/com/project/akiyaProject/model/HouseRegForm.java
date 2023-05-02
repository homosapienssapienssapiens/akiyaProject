package com.project.akiyaProject.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.CityEnum;

import lombok.Data;

@Data
public class HouseRegForm {
	private String house_id;
	@NotNull
	private List<CityEnum> location;
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
