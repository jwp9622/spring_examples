package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import com.example.WebServiceBasic.Repository.BoardManagerRepository;
import com.example.WebServiceBasic.Repository.BoardRepository;
import com.example.WebServiceBasic.dto.BoardDto;
import com.example.WebServiceBasic.service.BoardMangerCheckService;
import com.example.WebServiceBasic.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardMangerCheckService boardMangerCheckService;


    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardManagerRepository managerRepository;

    //접근 가능여부 체크 메소드
    BoardManager manager;

    @GetMapping("/board/{bid}")
    public String list(@PathVariable String bid, BoardDto dto, Model model){


        //게시판 제목 가져오기 체크
        manager = boardMangerCheckService.boardManagerGetInfo(bid);
        

        //글목록
        List<Board> boardList = boardService.list(bid, dto);

        model.addAttribute("boardName", manager.getBoardName());
        model.addAttribute("boardList", boardList);

        //4. 뷰 페이지 설정하기
        return "/board/boardList";
    }


    @GetMapping("/board/{bid}/{idx}")
    public String read(@PathVariable String bid, @PathVariable Long idx, Model model){

        //log.info("bid=====>"+bid);
        //log.info("idx=====>"+idx);

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //2. idx 값으로 데이터 가져오기
        //Board boardEntity = boardRepository.findByIdx(idx).orElse(null);

        //.info("boardEntity===>"+boardEntity);

        //3. 모델에 데이터 등록하기.
        //model.addAttribute("boardRead", boardEntity);

        //변수 가져오기
        //Long idx = n;



        //게시판 제목 등록여부 체크
        manager = boardMangerCheckService.boardManagerGetInfo(bid);

        //글내용
        Board board = boardService.read(bid, idx);

        //3. 모델에 데이터 등록하기.
        model.addAttribute("boardName", manager.getBoardName());
        model.addAttribute("boardRead", board);

        //4. 내용보기로 설정
        return "/board/boardRead";
    }


    @GetMapping("/board/{bid}/reg")
    public String reg(@PathVariable String bid, BoardDto dto, Model model){

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        //서비스 글등록 호출
        Board board = boardService.reg(bid);

        //2. 등록 페이지 설정
        return "/board/boardCreate";
    }

    @PostMapping("/board/{bid}/create")
    public String create(@PathVariable String bid, BoardDto dto){

        //0. bid 값을 받아온다.
        //String bid = dto.getBid();
        //model.addAttribute("bid",bid);
        //log.info("====bid===>"+bid);
        //log.info("====BoardForm===>"+dto.toString());

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //2.dto를 엔티티로 변환
       // Board board = dto.toEntity();
        //board.setDate(LocalDateTime.now());

        //3.db에 저장
        //Board saved = boardRepository.save(board);


        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        //글 등록 가져오기
        Board board = boardService.create(bid, dto);


        //4.목록으로 이동
        return "redirect:/board/"+bid+"/";
    }


    @GetMapping("/board/{bid}/{idx}/modify")
    public String modify(@PathVariable String bid, @PathVariable long idx, Model model){

        //인덱스값 다시 넘기기
        //Long idx = n;


        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //2. db 내용 가져오기
        //Board boardEntity = boardRepository.findByIdx(idx).orElse(null);

        //log.info("idx===>"+idx);
        //log.info("boardEntity===>"+boardEntity);



        //변수 가져오기
        //Long idx = n;

        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        //게시물 가져오기
        Board board = boardService.modify(bid, idx);

        //3. 모델에 넘겨주기
        model.addAttribute("boardName", manager.getBoardName());
        model.addAttribute("boardRead",board);

        //4. 수정 페이지 이동
        return "/board/boardEdit";
    }

    @PostMapping("/board/{bid}/{idx}/update")
    public String update(@PathVariable String bid, @PathVariable long idx, BoardDto dto){

        //0. bid 값을 받아온다.
        //String bid = form.getBid();

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //2. dto를 엔티티로 변환
        // boardEntity = form.toEntity();
        
        //3. db에서 기존 데이터가져와서 등록여부 확인
        // 존재여부 확인후 db에 저장
        //Board target = boardRepository.findByIdx(boardEntity.getIdx()).orElse(null);
        //if(target!=null){
        //    boardRepository.save(boardEntity);
        //}

        //변수 가져오기
        //Long idx = dto.getN();
        //String bid = dto.getBid();

        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        //내용 저장
        Board board = boardService.update(bid, idx, dto);

        //5. 상세내용 페이지 이동
        return "redirect:/board/"+bid+"/"+idx;
    }

    @GetMapping("/board/{bid}/{idx}/password")
    public String password(@PathVariable String bid, @PathVariable Long idx, Model model){

        //Long idx = n;

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //변수 가져오기
        //Long idx = n;

        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        Board board = boardService.password(bid, idx);

        //2.비밀번호 페이지 이동
        return "/board/boardPassword";
    }

    @PostMapping("/board/{bid}/{idx}/delete")
    public String delete(@PathVariable String bid, @PathVariable Long idx, BoardDto dto, RedirectAttributes rttr){

        //log.info("-----delete ------");
        //log.info("----form----"+form.toString());

        //0. bid 값을 받아온다.
        //String bid = form.getBid();
        //Long idx = form.getN();
        //log.info("bid====="+bid);
        //log.info("idx======="+idx);

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        //manager = managerRepository.findByBid(bid);
        //if(manager == null) return "redirect:/";

        //2. 글존재여부 확인후 삭제
        //Board target = boardRepository.findByBidAndIdxAndPassword(bid, idx, form.getPassword());

        //String retUrl;
        //if(target ==null ){
       //     rttr.addFlashAttribute("msg","비밀번호가 일치하지 않습니다.");
        //    retUrl = "/board/"+bid+"/password";
        //}else{
        //    boardRepository.delete(target);
        //    rttr.addFlashAttribute("msg","삭제되었습니다.");
        //    retUrl = "/board/"+bid+"/";
       // }

        //String bid = dto.getBid();
        //Long idx = dto.getIdx();
        String retUrl = "";

        //게시판 등록여부 체크
        //manager = boardMangerCheckService.boardManagerGetInfo(bid);

        Board board = boardService.delete(bid, idx, dto);
        if(board ==null ){
            rttr.addFlashAttribute("msg","비밀번호가 일치하지 않습니다.");
            retUrl = "/board/"+bid+"/password";
        }else {
            boardRepository.delete(board);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
            retUrl = "/board/" + bid + "/";
        }

        //3.리스트 페이지 이동
        return "redirect:"+retUrl;

    }

    @PostMapping("/board/transaction-test")
    public ResponseEntity<List<Board>> transactionTest(@RequestBody
                                                         List<BoardDto> dtos) {
        List<Board> createdList = boardService.createBoards(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
