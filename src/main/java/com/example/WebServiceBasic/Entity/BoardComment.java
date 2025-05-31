package com.example.WebServiceBasic.Entity;

import com.example.WebServiceBasic.dto.BoardCommentDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne // 이 엔티티(Comment)와 부모 엔티티(Article)를 다대일 관계로 설정
    @JoinColumn(name = "board_idx", referencedColumnName = "idx") // 외래키 생성, board 엔티티의 기본키(bid)와 매핑
    private Board board;

    @Column
    private String nickName;

    @Column
    private String content;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime date;


    public static BoardComment createComment(BoardCommentDto dto, Board board) {
        // 예외 발생
        //if (dto.getId() != null)
        //    throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (dto.getBoard_idx() != board.getIdx())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");

        // 엔티티 생성 및 반환
        return new BoardComment(
                dto.getIdx(), // 댓글 아이디
                board, // 부모 게시글
                dto.getNickName(), // 댓글 닉네임
                dto.getContent(), // 댓글 본문
                dto.getDate()
        );
    }

    public void patch(BoardCommentDto dto) {
        // 예외 발생
        if (this.idx != dto.getIdx())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다.");

        // 객체 갱신
        if (dto.getNickName() != null) // 수정할 닉네임 데이터가 있다면
            this.nickName = dto.getNickName(); // 내용을 반영

        if (dto.getContent() != null) // 수정할 본문 데이터가 있다면
            this.content = dto.getContent(); // 내용을 반영
    }

}
