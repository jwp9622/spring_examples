package com.example.WebServiceBasic.service;

import com.example.WebServiceBasic.Entity.BoardManager;
import com.example.WebServiceBasic.Repository.BoardManagerRepository;
import com.example.WebServiceBasic.Repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoardMangerCheckService {

    @Autowired
    private BoardManagerRepository boardManagerRepository;

    public String boardManagerCheck(String bid){
        BoardManager manager = boardManagerRepository.findByBid(bid).orElse(null);
        if(manager == null) return "error/404";
        return "";
    }

    public BoardManager boardManagerGetInfo(String bid){
        String chk = boardManagerCheck(bid);
        if(chk == null) return null;
        return boardManagerRepository.findByBid(bid).orElse(null);
    }


}
