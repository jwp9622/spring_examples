package com.example.WebServiceBasic.service;

import com.example.WebServiceBasic.Entity.Member;
import com.example.WebServiceBasic.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member login(String userid, String password){
        return memberRepository.findByUsername(userid)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);


    }

}
