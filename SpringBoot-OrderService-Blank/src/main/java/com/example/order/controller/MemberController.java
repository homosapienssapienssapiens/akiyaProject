package com.example.order.controller;

import com.example.order.model.member.JoinMemberForm;
import com.example.order.model.member.LoginForm;
import com.example.order.model.member.Member;
import com.example.order.repository.MemberRepository;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    // 회원가입 페이지 이
    @GetMapping("join")
    public String joinForm() {
        return "member/joinForm";
    }

    // 회원가입
    @PostMapping("join")
    public String join() {
        return "redirect:/";
    }

    // 로그인 페이지 이동
    @GetMapping("login")
    public String loginForm() {
        return "member/loginForm";
    }

    // 로그인
    @PostMapping("login")
    public String login() {
        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("logout")
    public String logout() {
        return "redirect:/";
    }

}
