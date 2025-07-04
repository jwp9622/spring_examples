package com.example.springbasic.controller;

import com.example.springbasic.config.AppConfig;
import com.example.springbasic.entity.Member;
import com.example.springbasic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 1. AOP를 사용한 트랜잭션 관리 구현하기
@Controller
public class testController {
    @GetMapping("/hi")
    public String greet(Model model){

        model.addAttribute("username","홍길동");
        return "greetings";
    }

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String index(){


        //포인트 넘기기 전
        long id1 = 1L;
        long id2 = 2L;
        Member member = memberService.detail(id1);
        Member member2 = memberService.detail(id2);
        System.out.println("Transactional 시작 전 포인트 ==> "+member.getName()+" 포인트="+member.getPoint());
        System.out.println("Transactional 시작 전 포인트 ==> "+member2.getName()+" 포인트="+member2.getPoint());

        //포인트 넘기기
        memberService.transfer(1,2,100);

        //포인트 넘기고 난후
        member = memberService.detail(id1);
        member2 = memberService.detail(id2);
        System.out.println("Transactional 시작 후 포인트 ==> "+member.getName()+" 포인트="+member.getPoint());
        System.out.println("Transactional 시작 후 포인트 ==> "+member2.getName()+" 포인트="+member2.getPoint());


        /*
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var memberService = context.getBean(MemberService.class);

        Member member = new Member();

        List<Member> list = memberService.list();
        System.out.println("Transactional 시작하기전 ==> "+list);

        //포인트 넘기기
        memberService.transfer(1,2,100);

        List<Member> list2 = memberService.list();
        System.out.println("Transactional 하고 난후  ==> "+list);
        */

        return "index";
    }

}
