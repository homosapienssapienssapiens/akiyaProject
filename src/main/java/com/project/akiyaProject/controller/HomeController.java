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
    
    @GetMapping("mapmarker")
    public String mapmarker() {
    	return "mapmarker";
    }
    
    @GetMapping("houseregister")
    public String houseregister() {
    	return "houseregister";
    }
}
