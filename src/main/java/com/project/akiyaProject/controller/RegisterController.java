package com.project.akiyaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.akiyaProject.model.HouseRegForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("register")
@Controller
public class RegisterController {

    @GetMapping("register")
    public String registrationForm(Model model) {
    	model.addAttribute("regForm", new HouseRegForm());
        return "houseRegister";
    }
    
    @PostMapping("register")
    public String registration(@ModelAttribute("regForm") HouseRegForm regForm, 
    						BindingResult result, Model model,
    						@RequestParam(required = false) MultipartFile file) {
    						
    	log.info("regForm:{}", regForm);
    	return "houseRegister";
    }
    

}
