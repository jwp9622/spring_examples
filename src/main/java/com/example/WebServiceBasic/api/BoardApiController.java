package com.example.WebServiceBasic.api;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.dto.BoardDto;
import com.example.WebServiceBasic.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    //목록 get
    @GetMapping("/api/board/{bid}")
    public List<Board> list(@PathVariable String bid, BoardDto dto){
        return boardService.list(bid, dto);
    }

    //상세내용 get
    @GetMapping("/api/board/{bid}/{idx}")
    public Board read(@PathVariable String bid, @PathVariable long idx){
        return boardService.read(bid, idx);

    }

    //등록post
    @PostMapping("/api/board/{bid}")
    public ResponseEntity<Board> create(@PathVariable String bid, @RequestBody BoardDto dto){
        Board board = boardService.create(bid, dto);
        return (board != null)?
                ResponseEntity.status(HttpStatus.OK).body(board):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //수정patch
    @PostMapping("/api/board/{bid}/{idx}")
    public ResponseEntity<Board> update(@PathVariable String bid,
                                              @PathVariable Long idx,
                                              @RequestBody BoardDto dto){
        Board board = boardService.update(bid, idx, dto);
        return (board != null)?
                ResponseEntity.status(HttpStatus.OK).body(board):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //삭제delete
    @Transactional
    @PostMapping("/api/board/{bid}/{idx}")
    public ResponseEntity<Board> delete(@PathVariable String bid, @PathVariable Long idx, BoardDto dto){
        Board board = boardService.delete(bid, idx, dto);
        return (board != null)?
                ResponseEntity.status(HttpStatus.OK).body(board):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
