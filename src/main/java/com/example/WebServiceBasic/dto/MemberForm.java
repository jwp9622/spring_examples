package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class MemberForm {
    int idx;
    String userid;
    String email;
    String password;
    Date date;

    public Member toEntity(){
        return new Member(idx, userid, email, password, date);
    }
}
