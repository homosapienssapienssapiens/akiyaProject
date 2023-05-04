package com.project.akiyaProject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.model.HouseInfoToMap;
import com.project.akiyaProject.repository.HouseMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequestMapping("list")
@RequiredArgsConstructor
@Controller
public class SearchConditionController {
	
	public final HouseMapper housemapper;

    @GetMapping("allListOnMap")
    public String allList(Model model) {
    	List<HouseInfo> houseList = housemapper.getAllHouseList();
    	List<HouseInfoToMap> houseListMap = new ArrayList<>();
    	for (Iterator iterator = houseList.iterator(); iterator.hasNext();) {
			HouseInfo houseInfo = (HouseInfo) iterator.next();
			houseListMap.add(HouseInfoToMap.toHouseInfoToMap(houseInfo));
		}
    	model.addAttribute("houseList", houseListMap);
        return "viewOnMap";
    }
}
