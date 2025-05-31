package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class BoardDto {
    private Long idx;
    private String bid;
    private String title;
    private String name;
    private String content;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long n;
    private String keyword;

    public Board toEntity(){
        return new Board(idx, bid, title, name, content, password, createdDate, modifiedDate);
    }
}
