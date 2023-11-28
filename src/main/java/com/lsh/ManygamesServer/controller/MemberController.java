package com.lsh.ManygamesServer.controller;

import com.lsh.ManygamesServer.domain.Member;
import com.lsh.ManygamesServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     * @param name : 로그인 이름
     * @param password : 비밀번호
     * @return : 성공시 "SUCCESS", 실패시 "FAIL"
     */
    @PostMapping("/member/register")
    public String register(@RequestParam String name, @RequestParam String password) {
        if (memberService.register(name, password)) {
            return "SUCCESS";
        }
        else {
            return "FAIL";
        }
    }

    /**
     * 로그인
     * @param name : 로그인 이름
     * @param password : 비밀번호
     * @return : 성공시 "SUCCESS", 실패시 "FAIL"
     */
    @PostMapping("/member/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        Member member = memberService.login(name, password).orElse(null);
        if(member == null) {
            return "FAIL";
        }
        return "SUCCESS";
    }
}
