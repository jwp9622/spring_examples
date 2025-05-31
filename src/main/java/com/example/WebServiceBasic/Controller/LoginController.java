package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Member;
import com.example.WebServiceBasic.Repository.MemberRepository;
import com.example.WebServiceBasic.dto.MemberDto;
import com.example.WebServiceBasic.service.MemberService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberDto memberDto;

    @GetMapping("/login")
    public String loginForm(Model model){

        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto dto, HttpServletRequest http, Model model){

        Member member = memberService.login(dto.getUserId(), dto.getPassword());

        if(member == null){
            model.addAttribute("msg","아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }
        Object request;
        HttpSession session = http.getSession();
        session.setAttribute("member",member);

        return "login/login";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest http){
        HttpSession session = http.getSession(false);
        if( session !=null){
            session.invalidate();
        }
        return "redirect:/";
    }

}
