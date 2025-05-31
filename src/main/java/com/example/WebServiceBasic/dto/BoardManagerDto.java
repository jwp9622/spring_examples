package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.BoardManager;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BoardManagerDto {
    private int idx;
    private String bid;
    private String boardName;
    private int pageSize;
    private String date;

    public BoardManager Entity(){
        return new BoardManager(idx, bid, boardName, pageSize, date);
    }
}
