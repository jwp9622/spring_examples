package com.example.springbasic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    @Column
    private int point;

    public Member(Long id, String name, String email, int point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.point = point;
    }

}
