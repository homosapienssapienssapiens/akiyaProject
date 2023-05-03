package com.project.akiyaProject.model;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.CityEnum;
import com.project.akiyaProject.model.Enum.ConditionEnum;

import lombok.Data;

@Data
public class HouseRegForm {
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
	private List<String> condition;
	private List<String> must;
	
	public static HouseInfo toHouseInfo(HouseRegForm regForm) {
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setCity(regForm.getCity());
		houseInfo.setAddress(regForm.getAddress());
		houseInfo.setPrice(regForm.getPrice());
		houseInfo.setCompleted(regForm.getCompleted());
		houseInfo.setFloor(regForm.getFloor());
		houseInfo.setHousesize(regForm.getHousesize());
		String[] conditionList = {"bus", "subway", "convini", "hospital", "aircon", "bathroom", "parking", "washer", "pet", "autolock"};
		for (int i = 0; i< conditionList.length; i++) {
			try {
			Field field = houseInfo.getClass().getDeclaredField(conditionList[i]); 
			field.setAccessible(true);
			field.set(houseInfo,ConditionEnum.Unnecessary);
			} catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
			
		}
		for (Iterator iterator = regForm.getCondition().iterator(); iterator.hasNext();) {
			try {
				Field field = houseInfo.getClass().getDeclaredField((String) iterator.next()); 
				field.setAccessible(true);
				field.set(houseInfo,ConditionEnum.Prefer);
			} catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		for (Iterator iterator = regForm.getMust().iterator(); iterator.hasNext();) {
			try {
				Field field = houseInfo.getClass().getDeclaredField((String) iterator.next()); 
				field.setAccessible(true);
				field.set(houseInfo,ConditionEnum.Must);
			} catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		
		
		return houseInfo;
	}
}

