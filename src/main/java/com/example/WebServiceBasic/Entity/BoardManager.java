package com.example.WebServiceBasic.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class BoardManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    int idx;

    @Column
    String bid;

    @Column
    String boardName;

    @Column
    int pageSize;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    String date;

}
