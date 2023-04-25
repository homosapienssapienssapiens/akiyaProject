package com.project.akiyaProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.model.HouseRegForm;
import com.project.akiyaProject.service.RentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("rent")
@Controller
public class RentController {

    private final RentService rentService;

	@GetMapping("registration")
	public String registrationForm(Model model) {
		model.addAttribute("writeForm", new HouseRegForm());
		return "board/write";
	}

//    매물 상세 정보 보기
	@GetMapping("/list/{house_id}")
	public ResponseEntity<HouseInfo> getHouseInfo(@PathVariable String house_id) {
		HouseInfo houseInfo = rentService.getHouseById(house_id);
		if (houseInfo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(houseInfo);
		}
	}

}
