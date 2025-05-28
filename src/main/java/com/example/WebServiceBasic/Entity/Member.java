package com.example.WebServiceBasic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue
    private int idx;

    @Column
    private String userid;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

}
