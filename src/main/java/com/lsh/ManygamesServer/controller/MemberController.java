package com.lsh.ManygamesServer.controller;

import com.lsh.ManygamesServer.SessionConst;
import com.lsh.ManygamesServer.domain.Member;
import com.lsh.ManygamesServer.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
    public String login(@RequestParam String name, @RequestParam String password, HttpServletRequest request,
        HttpServletResponse response) {
        Member member = memberService.login(name, password).orElse(null);
        if(member == null) {
            return "FAIL";
        }

        // 세션 저장
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        // 유니티 클라이언트에서 사용할 JSESSIONID 쿠키에 포함해서 전달
        Cookie cookie = new Cookie("jsessionid", session.getId());
        response.addCookie(cookie);

        return "SUCCESS";
    }

    @GetMapping("/member/logout")
    public void logout(HttpServletRequest request) {
        // 세션 존재하면 파기
        HttpSession session = request.getSession();
        if(session != null) {
            session.invalidate();
        }
    }

}
