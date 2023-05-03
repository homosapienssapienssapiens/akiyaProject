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

import com.project.akiyaProject.model.HouseInfo;
import com.project.akiyaProject.model.HouseRegForm;
import com.project.akiyaProject.model.Member;
import com.project.akiyaProject.repository.HouseMapper;
import com.project.akiyaProject.repository.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("register")
@Controller
public class RegisterController {
	
	private final HouseMapper houseMapper;
	private final MemberMapper memberMapper;

	@GetMapping("test")
	public String test(Model model) {
		Member member = new Member();
		member.setMember_id("lsw0520");
		member.setPassword("1234");
		member.setEmail("dltkddnl0141@gmail.com");
		member.setCountry("ko");
		member.setRevised("TRUE");
		memberMapper.saveMember(member);
		return "houseRegister";
	}
	
    @GetMapping("register")
    public String registrationForm(Model model) {
    	model.addAttribute("regForm", new HouseRegForm());
        return "houseRegister";
    }
    
    @PostMapping("register")
    public String registration(@ModelAttribute("regForm") HouseRegForm regForm, 
    						BindingResult result, Model model,
    						@RequestParam(required = false) MultipartFile file) {
        if (result.hasErrors()) {
            return "houseRegister";
        }
        log.info("regForm:{}", regForm);
        HouseInfo houseInfo = HouseRegForm.toHouseInfo(regForm);
        log.info(houseInfo.toString());
//        houseMapper.saveHouseInfo(houseInfo);
    	return "index";
    }
    

}
