package com.project.akiyaProject.model;

import com.project.akiyaProject.model.Enum.CityEnum;
import com.project.akiyaProject.model.Enum.ConditionEnum;
import com.project.akiyaProject.model.Enum.Position;

import lombok.Data;
@Data
public class HouseInfoToMap {
	private String address;
	private Long price;
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
	private ConditionEnum over2f;
	private Position position;
	
	public static HouseInfoToMap toHouseInfoToMap(HouseInfo houseinfo) {
		HouseInfoToMap houseInfoToMap = new HouseInfoToMap();
		houseInfoToMap.setAddress(houseinfo.getAddress());
		houseInfoToMap.setPrice(houseinfo.getPrice());
		houseInfoToMap.setHousesize(houseinfo.getHousesize());
		houseInfoToMap.setBus(houseinfo.getBus());
		houseInfoToMap.setSubway(houseinfo.getSubway());
		houseInfoToMap.setConvini(houseinfo.getConvini());
		houseInfoToMap.setHospital(houseinfo.getHospital());
		houseInfoToMap.setAircon(houseinfo.getAircon());
		houseInfoToMap.setBathroom(houseinfo.getBathroom());
		houseInfoToMap.setParking(houseinfo.getParking());
		houseInfoToMap.setWasher(houseinfo.getWasher());
		houseInfoToMap.setPet(houseinfo.getPet());
		houseInfoToMap.setAutolock(houseinfo.getAutolock());

		if(houseinfo.getFloor() > 1) {
			houseInfoToMap.setOver2f(ConditionEnum.Must);
		} else {
			houseInfoToMap.setOver2f(ConditionEnum.Unnecessary);
		}
		
		Position position = new Position();
		position.setLat(houseinfo.getLatitude());
		position.setLng(houseinfo.getLongitude());
		houseInfoToMap.setPosition(position);
		
		return houseInfoToMap;
	}

	@Override
	public String toString() {
		return "HouseInfoToMap [address=" + address + ", price=" + price + ", housesize=" + housesize + ", bus=" + bus
				+ ", subway=" + subway + ", convini=" + convini + ", hospital=" + hospital + ", aircon=" + aircon
				+ ", bathroom=" + bathroom + ", parking=" + parking + ", washer=" + washer + ", pet=" + pet
				+ ", autolock=" + autolock + ", over2f=" + over2f + ", position=" + position + "]";
	}
	

}
