package com.example.springbasic.service;

import com.example.springbasic.entity.Member;
import com.example.springbasic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> list(){
        return memberRepository.findAll();
    }

    public Member detail(long id){
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public void transfer(long sid, long rid, int point){
        Member sender = memberRepository.findById(sid).orElse(null);
        Member receiver = memberRepository.findById(rid).orElse(null);

        int send_point = sender.getPoint()-point;
        int receive_point = receiver.getPoint()+point;

        sender.setPoint(send_point);
        receiver.setPoint(receive_point);

        System.out.println("send_point="+send_point);
        System.out.println("receive_point="+receive_point);

        memberRepository.save(sender);
        memberRepository.save(receiver);
    }

}
