package com.project.akiyaProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
	
    @GetMapping("")
    public String home() {
        return "index";
    }
    
    @GetMapping("housefinder")
    public String housefinder() {
        return "housefinder";
    }
    
    @GetMapping("viewOnMap")
    public String viewOnMap() {
    	return "viewOnMap";
    }
    @GetMapping("houseRegister")
    public String houseRegister() {
    	return "houseRegister";
    }
    @GetMapping("buyhouse")
    public String buyhouse() {
    	return "buyhouse";
    }
    @GetMapping("lentalhouse")
    public String lentalhouse() {
    	return "lentalhouse";
    }
    
    
}
