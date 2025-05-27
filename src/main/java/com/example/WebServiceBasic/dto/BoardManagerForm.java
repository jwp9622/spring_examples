package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.BoardManager;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BoardManagerForm {
    int idx;
    String bid;
    String boardName;
    int pageSize;
    String date;

    public BoardManager Entity(){
        return new BoardManager(idx, bid, boardName, pageSize, date);
    }
}
