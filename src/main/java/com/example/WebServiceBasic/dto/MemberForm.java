package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    String id;
    String email;
    String password;

    public Member toEntity(){
        return new Member(null, email, password);
    }
}
