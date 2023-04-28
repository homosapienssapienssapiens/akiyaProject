package com.project.akiyaProject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
    @GetMapping("")
    public String home() {
        return "index";
    }
    
    @GetMapping("list")
    public String housefinder() {
        return "list";
    }
    
    @GetMapping("viewOnMap")
    public String viewOnMap() {
    	return "viewOnMap";
    }
    @GetMapping("houseRegister")
    public String houseRegister() {
    	return "houseRegister";
    }
    @GetMapping("findHomeBuy")
    public String lentalhouse() {
    	return "findHomeBuy";
    }
    @GetMapping("details")
    public String details() {
    	return "details";
    }
    @GetMapping("index_dark")
    public String index_dark() {
    	return "index_dark";
    }
    @GetMapping("introduce")
    public String introduce() {
    	return "introduce";
    }
    
    
}
