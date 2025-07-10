package com.example.WebServiceBasic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue
    String id;

    @Column
    String email;

    @Column
    String password;


}
