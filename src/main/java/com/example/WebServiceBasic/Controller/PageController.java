package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Member;
import com.example.WebServiceBasic.Repository.MemberRepository;
import com.example.WebServiceBasic.dto.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PageController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/intro")
    public String intro(){
        return "intro";
    }

    @GetMapping("/notice")
    public String notice(){
        return "notice";
    }

    @GetMapping("/contactus")
    public String contactus(){
        return "contactus";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }


}
