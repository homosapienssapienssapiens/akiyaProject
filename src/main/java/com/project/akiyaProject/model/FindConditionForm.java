package com.project.akiyaProject.model;

import java.lang.reflect.Field;

import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.project.akiyaProject.model.Enum.ConditionEnum;

import lombok.Data;

@Data
public class FindConditionForm {
	
	@NotNull
	List<String> city;
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
	private List<String> condition;
	private List<String> must;
	
	public static HouseInfo toHouseInfo(FindConditionForm findConditionForm) {
		HouseInfo houseInfo = new HouseInfo();
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
		for (Iterator iterator = findConditionForm.getCondition().iterator(); iterator.hasNext();) {
			try {
				Field field = houseInfo.getClass().getDeclaredField((String) iterator.next()); 
				field.setAccessible(true);
				field.set(houseInfo,ConditionEnum.Prefer);
			} catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		for (Iterator iterator = findConditionForm.getMust().iterator(); iterator.hasNext();) {
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
