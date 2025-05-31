package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberDto {
    private Long idx;
    private String userId;
    private String email;
    private String username;
    private String password;
    private Date date;


    public Member toEntity(){
        return new Member(idx, userId, email, username, password, date);
    }
}
