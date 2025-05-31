package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
