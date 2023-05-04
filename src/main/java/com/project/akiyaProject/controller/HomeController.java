package com.project.akiyaProject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
    @GetMapping("/")
    public String home(HttpServletRequest request) {
    	
    	Locale currentLocale = request.getLocale();
    	String countryCode = currentLocale.getCountry();
    	String countryName = currentLocale.getDisplayCountry();
    	
    	String langCode = currentLocale.getLanguage();
    	String langName = currentLocale.getDisplayLanguage();
    	
    	System.out.println(countryCode + ": " + countryName);
    	System.out.println(langCode + ": " + langName);
    	
//    	langCode: 
//    	ja: 일본어
//    	zh: 중국어
//    	ko: 한국어
    	
//    	System.out.println("==========");
//    	String[] languages = Locale.getISOLanguages();
//    	
//    	for (String languege : languages) {
//    		Locale locale = new Locale(languege);
//    		System.out.println(languege + ": " + locale.getDisplayLanguage());
//    	}
    	
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
    @GetMapping("introduce_dark")
    public String introduce_dark() {
    	return "introduce_dark";
    }
    
    
}
