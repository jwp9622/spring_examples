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
    int idx;

    @Column
    String userid;

    @Column
    String email;

    @Column
    String password;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Date date;

}
