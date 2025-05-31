package com.example.WebServiceBasic.dto;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardComment;
import com.example.WebServiceBasic.Entity.BoardManager;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class BoardCommentDto {
    private long idx;
    private long board_idx;
    private String nickName;
    private String content;
    private LocalDateTime date;

    public BoardComment toEntity(Board board){
           return new BoardComment(idx,board, nickName, content, date);
    }

    public static BoardCommentDto createCommentDto(BoardComment comment) {
        return new BoardCommentDto(
                comment.getIdx(), // 댓글 엔티티의 idx
                comment.getBoard().getIdx(), // 댓글 엔티티가 속한 부모 게시글의 id
                comment.getNickName(), // 댓글 엔티티의 nickname
                comment.getContent(), // 댓글 엔티티의 body
                comment.getDate()
        );
    }


}