package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import com.example.WebServiceBasic.Repository.BoardManagerRepository;
import com.example.WebServiceBasic.Repository.BoardRepository;
import com.example.WebServiceBasic.dto.BoardForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardManagerRepository managerRepository;

    //접근 가능여부 체크 메소드
    BoardManager manager;

    @GetMapping("/board/{bid}/")
    public String boardList(@PathVariable String bid, Model model){

        //게시판 아이디 출력
        log.info("bid="+bid);

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. 데이터 가져오기
        List<Board> board = boardRepository.findByBid(bid);

        //3. 모델에 데이터 등록하기
        model.addAttribute("bid", bid);
        model.addAttribute("boardList", board);

        //4. 뷰 페이지 설정하기
        return "/board/boardList";
    }


    @GetMapping("/board/{bid}/{idx}")
    public String boardRead(@PathVariable String bid, @PathVariable Long idx, Model model){

        log.info("bid=====>"+bid);
        log.info("idx=====>"+idx);

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. idx 값으로 데이터 가져오기
        Board boardEntity = boardRepository.findByIdx(idx);

        log.info("boardEntity===>"+boardEntity);

        //3. 모델에 데이터 등록하기.
        model.addAttribute("boardRead", boardEntity);

        //4. 내용보기로 설정
        return "/board/boardRead";
    }


    @GetMapping("/board/{bid}/write")
    public String boardWrite(@PathVariable String bid, BoardForm form){

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. 등록 페이지 설정
        return "/board/boardWrite";
    }

    @PostMapping("/board/writeUpdate")
    public String boardCreate(BoardForm form, Model model){

        //0. bid 값을 받아온다.
        String bid = form.getBid();
        //model.addAttribute("bid",bid);
        log.info("====bid===>"+bid);
        log.info("====BoardForm===>"+form.toString());

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2.dto를 엔티티로 변환
        Board board = form.toEntity();
        //board.setDate(LocalDateTime.now());

        //3.db에 저장
        Board saved = boardRepository.save(board);

        //4.목록으로 이동
        return "redirect:/board/"+bid+"/";
    }


    @GetMapping("/board/{bid}/modify")
    public String boardModify(@PathVariable String bid, @RequestParam Long n, Model model){

        //인덱스값 다시 넘기기
        Long idx = n;


        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. db 내용 가져오기
        Board boardEntity = boardRepository.findByIdx(idx);

        log.info("idx===>"+idx);
        log.info("boardEntity===>"+boardEntity);

        //3. 모델에 넘겨주기
        model.addAttribute("boardRead",boardEntity);



        //4. 수정 페이지 이동
        return "/board/boardModify";
    }

    @PostMapping("/board/{bid}/modifyUpdate")
    public String boardUpdate(BoardForm form, Model model){

        //0. bid 값을 받아온다.
        String bid = form.getBid();

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. dto를 엔티티로 변환
        Board boardEntity = form.toEntity();
        
        //3. db에서 기존 데이터가져와서 등록여부 확인
        // 존재여부 확인후 db에 저장
        Board target = boardRepository.findByIdx(boardEntity.getIdx());
        if(target!=null){
            boardRepository.save(boardEntity);
        }

        //5. 상세내용 페이지 이동
        return "redirect:/board/"+bid+"/"+boardEntity.getIdx();
    }

    @GetMapping("/board/{bid}/password")
    public String boardPassword(@PathVariable String bid, @RequestParam Long n, Model model){

        Long idx = n;

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        model.addAttribute("idx",idx);

        //2.비밀번호 페이지 이동
        return "/board/boardPassword";
    }


    @PostMapping("/board/{bid}/delete")
    public String boardDelete(BoardForm form, Model model, RedirectAttributes rttr){
        log.info("-----delete ------");
        log.info("----form----"+form.toString());

        //0. bid 값을 받아온다.
        String bid = form.getBid();
        Long idx = form.getN();
        log.info("bid====="+bid);
        log.info("idx======="+idx);

        //1. 해당 게시판 있는지 여부 체크후 없으면 메인으로 이동
        manager = managerRepository.findByBid(bid);
        if(manager == null) return "redirect:/";

        //2. 글존재여부 확인후 삭제
        Board target = boardRepository.findByBidAndIdxAndPassword(bid, idx, form.getPassword());

        String retUrl;
        if(target ==null ){
            rttr.addFlashAttribute("msg","비밀번호가 일치하지 않습니다.");
            retUrl = "/board/"+bid+"/password";
        }else{
            boardRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제되었습니다.");
            retUrl = "/board/"+bid+"/";
        }

        //3.리스트 페이지 이동
        return "redirect:"+retUrl;


    }

}
