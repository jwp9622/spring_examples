package com.example.WebServiceBasic.service;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import com.example.WebServiceBasic.Repository.BoardManagerRepository;
import com.example.WebServiceBasic.Repository.BoardRepository;
import com.example.WebServiceBasic.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardManagerRepository boardManagerRepository;

    @Autowired
    private BoardMangerCheckService boardMangerCheckService;


    BoardManager manager;

    //목록
    public List<Board> list(String bid, BoardDto dto){

        String val = boardMangerCheckService.boardManagerCheck(bid);

        if(dto.getKeyword() != ""){
            return boardRepository.findByBidTitle(bid, dto.getTitle());
        }else{
            return boardRepository.findByBid(bid);
        }
    }


    //내용보기
    public Board read(String bid, Long idx){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        return boardRepository.findByBidAndIdx(bid, idx).orElse(null);
    }

    //등록폼
    public Board reg(String bid){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        return null;
    }

    //등록 업데이트
    public Board create(String bid, BoardDto dto){

        //게시판 등록여부 체크
        //String bid = dto.getBid();
        String val = boardMangerCheckService.boardManagerCheck(bid);


        Board board = dto.toEntity();
        if(board.getIdx() != null) return null;
        return boardRepository.save(board);
    }
    
    //수정폼
    public Board modify(String bid, Long idx){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        //글 등록여부 체크
        Board target = boardRepository.findByBidAndIdx(bid, idx).orElse(null);
        if(target == null || idx != target.getIdx()){
            return null;
        }
        
        //Board updated = boardRepository.save(board);
        return target;
    }
    //수정하기
    @Transactional
    public Board update(String bid, Long idx, BoardDto dto){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        Board board = dto.toEntity();

        Board target = boardRepository.findByBidAndIdx(bid, idx).orElse(null);
        if(target == null || idx != target.getIdx()){
            return null;
        }
        Board updated = boardRepository.save(board);
        return updated;
    }
    //비밀번호
    public Board password(String bid, Long idx){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        Board target = boardRepository.findByBidAndIdx(bid, idx).orElse(null);
        if(target == null || idx != target.getIdx()){
            return null;
        }
        return target;
    }

    //삭제
    @Transactional
    public Board delete(String bid, Long idx, BoardDto dto){

        //게시판 등록여부 체크
        String val = boardMangerCheckService.boardManagerCheck(bid);

        //2. 글존재여부 확인후 삭제
        Board target = boardRepository.findByBidAndIdxAndPassword(bid, idx, dto.getPassword());

        if(target == null ){
            return null;
        }else{
            boardRepository.delete(target);
        }
        return target;
    }

    //테스트하기
    @Transactional
    public List<Board> createBoards(List<BoardDto> dtos) {

        // 1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Board> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        // 2. 엔티티 묶음을 DB에 저장하기
        articleList.stream()
                .forEach(article -> boardRepository.save(article));

        // 3. 강제 예외 발생시키기
        boardRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패!"));

        // 4. 결과값 반환하기
        return articleList;
    }

}
