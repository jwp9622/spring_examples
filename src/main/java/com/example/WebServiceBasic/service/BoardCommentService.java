package com.example.WebServiceBasic.service;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardComment;
import com.example.WebServiceBasic.Repository.BoardCommentRepository;
import com.example.WebServiceBasic.Repository.BoardRepository;
import com.example.WebServiceBasic.dto.BoardCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardCommentService {
    @Autowired
    private BoardCommentRepository boardCommentRepository;

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardCommentDto> comments(Long board_idx){

        return boardCommentRepository.findByBoardIdx(board_idx) // 1. 특정 게시글의 댓글 조회
                .stream()   // 2. Stream으로 변환
                .map(comment -> BoardCommentDto.createCommentDto(comment)) // 3. DTO 변환
                .collect(Collectors.toList());  // 4. 리스트로 수집

    }

    @Transactional
    public BoardCommentDto create(Long board_idx, BoardCommentDto dto){

        // 1. 게시글 조회 및 예외 발생
        Board board = boardRepository.findByIdx(board_idx)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! " +
                        "대상 게시글이 없습니다."));

        // 2. 댓글 엔티티 생성
        BoardComment boardComment = BoardComment.createComment(dto, board);

        // 3. 댓글 엔티티를 DB로 저장
        BoardComment created = boardCommentRepository.save(boardComment);

        // 4. DTO로 변환하여 반환
        return BoardCommentDto.createCommentDto(created);


    }

    public BoardCommentDto update(Long idx, BoardCommentDto dto){

        // 1. 댓글 조회 및 예외 발생
        BoardComment target = boardCommentRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!" +
                        "대상 댓글이 없습니다."));

        // 2. 댓글 수정
        target.patch(dto);

        // 3. DB로 갱신
        BoardComment updated = boardCommentRepository.save(target);

        // 4. 댓글 엔티티를 DTO로 변환 및 반환
        return BoardCommentDto.createCommentDto(updated);

    }

    public BoardCommentDto delete(Long idx){
        // 1. 댓글 조회 및 예외 발생
        BoardComment target = boardCommentRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! " +
                        "대상이 없습니다."));

        // 2. 댓글 삭제
        boardCommentRepository.delete(target);

        // 3. 삭제 댓글을 DTO로 변환 및 반환
        return BoardCommentDto.createCommentDto(target);
    }

}
