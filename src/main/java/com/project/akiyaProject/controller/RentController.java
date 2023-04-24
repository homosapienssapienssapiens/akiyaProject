package com.project.akiyaProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.model.HouseRegForm;
import com.project.akiyaProject.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor
@RequestMapping("rent")
@Controller
public class RentController {

//    private final RentService rentService;

<<<<<<< HEAD
    @GetMapping("registration")
    public String registrationForm(Model model) {
    	model.addAttribute("writeForm", new HouseRegForm());
        return "board/write";
    }


    
//    매물 상세 정보 보기
    @GetMapping("/list/{house_id}")	
    public ResponseEntity<HouseInfo> getHouseInfo(@PathVariable String house_id) {
        HouseInfo houseinfo = RentService.getHouseById(house_id);
        if (houseinfo == null) {
=======

//    매물 전체 보기
    @GetMapping("/list/{house_id}")
    public ResponseEntity<HouseInfo> getHouseInfo(@PathVariable String house_id) {
    	HouseInfo houseInfo = RentService.getHouseById(house_id);
        if ( houseInfo == null) {
>>>>>>> branch 'master' of https://github.com/homosapienssapienssapiens/akiyaProject.git
            return ResponseEntity.notFound().build();
        } else {
<<<<<<< HEAD
            return ResponseEntity.ok(houseinfo);
=======
            return ResponseEntity.ok(houseInfo);
>>>>>>> branch 'master' of https://github.com/homosapienssapienssapiens/akiyaProject.git
        }
    }
    

}
