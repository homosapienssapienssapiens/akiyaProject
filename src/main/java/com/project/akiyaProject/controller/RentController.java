package com.project.akiyaProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.akiyaProject.service.RentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class RentController {

    private final RentService rentService;

    @Value("${file.upload.path}")
    private String uploadPath;

    @GetMapping("write")
    public String writeForm(Model model) {

        return "board/write";
    }


}
