package com.example.WebServiceBasic.api;

import com.example.WebServiceBasic.dto.BoardCommentDto;
import com.example.WebServiceBasic.service.BoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private BoardCommentService boardCommentService;

    //목록
    @GetMapping("/api/board/{board_idx}/comments")
    public ResponseEntity<List<BoardCommentDto> >list(@PathVariable Long board_idx){

        List<BoardCommentDto> boardCommentDto = boardCommentService.comments(board_idx);

        return ResponseEntity.status(HttpStatus.OK).body(boardCommentDto);
    }
    
    //등록
    @PostMapping("/api/board/{board_idx}/comments")
    public ResponseEntity<BoardCommentDto> update(@PathVariable Long board_idx,
                                  @RequestBody BoardCommentDto dto){

        BoardCommentDto boardCommentDto = boardCommentService.update(board_idx, dto);

        return ResponseEntity.status(HttpStatus.OK).body(boardCommentDto);
    }
    
    //수정
    @PatchMapping("/api/board/{idx}")
    public ResponseEntity<BoardCommentDto> create(@PathVariable Long idx,
                                                  @RequestBody BoardCommentDto dto){

        BoardCommentDto boardCommentDto = boardCommentService.update(idx, dto);

        return ResponseEntity.status(HttpStatus.OK).body(boardCommentDto);
    }

    //삭제
    @PatchMapping("/api/board/{idx}")
    public ResponseEntity<BoardCommentDto> delete(@PathVariable Long idx){

        BoardCommentDto boardCommentDto = boardCommentService.delete(idx);

        return ResponseEntity.status(HttpStatus.OK).body(boardCommentDto);
    }

}
