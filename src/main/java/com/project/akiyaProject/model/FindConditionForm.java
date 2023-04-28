package com.project.akiyaProject.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.BooleanEnum;

import lombok.Data;
@Data
public class FindConditionForm {
	@NotNull
	List<String> citys;
	@Min(value=1)
	@Max(value=300)
	private Long price_min;
	@Min(value=1)
	@Max(value=300)
	private Long price_max;
	@Min(value=1)
	@Max(value=300)
	private Long houseSize_min;
	@Min(value=1)
	@Max(value=300)
	private Long houseSize_max;
	@NotNull
	private BooleanEnum bus;
	@NotNull
	private BooleanEnum subway; 
	@NotNull
	private BooleanEnum convini;
	@NotNull
	private BooleanEnum hospital;
	@NotNull
	private BooleanEnum aircon;
	@NotNull
	private BooleanEnum bathroom;
	@NotNull
	private BooleanEnum parking;
	@NotNull
	private BooleanEnum washer;
	@NotNull
	private BooleanEnum pet;
	@NotNull
	private BooleanEnum autolock;
}
