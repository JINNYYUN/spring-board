package com.jinny.board.controller;

import com.jinny.board.dto.MemberDTO;
import com.jinny.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired    // DI IOC
    MemberService memberService;

    @GetMapping("login.do")
    public String login() {
        return "login";
    }

    @GetMapping("signup.do")
    public String moveSignup(MemberDTO memberDTO) {
        return "signup";
    }

    @ResponseBody
    @PostMapping("member/signup.do")
    public String signup(@RequestBody MemberDTO memberDTO) {
        int checkNum = memberService.insertNewMember(memberDTO);

        return checkNum>0? "GOOD" : "FAIL";
    }
}
