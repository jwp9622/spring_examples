package com.example.WebServiceBasic.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long idx;

    @Column
    private String userId;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

}
