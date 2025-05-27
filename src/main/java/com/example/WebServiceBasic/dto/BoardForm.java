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
    Long idx;
    String bid;
    String title;
    String name;
    String content;
    String password;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
    Long n;

    public Board toEntity(){
        return new Board(idx, bid, title, name, content, password, createdDate, modifiedDate);
    }
}
