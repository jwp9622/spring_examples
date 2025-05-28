package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Board;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class BoardForm {
    private Long idx;
    private String bid;
    private String title;
    private String name;
    private String content;
    private  String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long n;

    public Board toEntity(){
        return new Board(idx, bid, title, name, content, password, createdDate, modifiedDate);
    }
}
