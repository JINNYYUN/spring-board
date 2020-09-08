package com.jinny.board.controller;

import com.jinny.board.dto.MemberDTO;
import com.jinny.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    @Autowired    // DI IOC
    MemberService memberService;

    @GetMapping("member/login")
    public String login() {
        return "login";
    }

    @GetMapping("member/signup")
    public String moveSignup(MemberDTO memberDTO) {
        return "signup";
    }

    /**
     * 회원가입시 이메일 체크
     * @param userEmail
     * @return 1이면 중복, 0이면 중복 아님
     */
    @ResponseBody
    @PostMapping("member/emailCheck")
    public int checkEmail(@RequestParam(value = "email") String userEmail) {
        int result = memberService.findDuplicateEmail(userEmail);

        return result;
    }

    @ResponseBody
    @PostMapping("member/signup")
    public String signup(@RequestBody MemberDTO memberDTO) {
        int checkNum = memberService.insertNewMember(memberDTO);

        return checkNum>0? "GOOD" : "FAIL";
    }
}
