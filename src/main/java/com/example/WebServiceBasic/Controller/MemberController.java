package com.example.WebServiceBasic.Controller;

import com.example.WebServiceBasic.Entity.Member;
import com.example.WebServiceBasic.Repository.MemberRepository;
import com.example.WebServiceBasic.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    //목록
    @GetMapping("/members")
    public String list(@PathVariable Long id, Model model){
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("members", member);
        return "members/memberList";
    }

    //상세내용
    @GetMapping("/members/{idx}")
    public String info(@PathVariable Long idx, Model model){
        Member member = memberRepository.findByIdx(idx).orElse(null);
        return "member/memberDetail";
    }

    //등록폼
    @GetMapping("/members/signup")
    public String singUp(){
        return "";
    }

    //등록
    @PostMapping("/members/join")
    public String join(MemberDto dto){
        Member member = dto.toEntity();
        Member saved = memberRepository.save(member);

        return "redirect:/members/"+saved.getIdx();
    }

    
    //수정폼
    @GetMapping("/members/{idx}/edit")
    public String edit(@PathVariable Long idx, Model model){
        Member member = memberRepository.findByIdx(idx).orElse(null);
        model.addAttribute("member",member);
        return "members/membersEdit";
    }

    //수정
    @PostMapping("/members/update")
    public String update(MemberDto dto){
        Member member = dto.toEntity();

        Member target = memberRepository.findByIdx((long) member.getIdx()).orElse(null);
        if(target != null) {
            memberRepository.save(member);
        }
        return "redirect:/members/"+member.getIdx();
    }

    //삭제
    @Transactional
    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long idx, RedirectAttributes rttr){
        Member member = memberRepository.findByIdx(idx).orElse(null);
        if(member != null){
            memberRepository.delete(member);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
        }
        return "redirect:/members";
    }

}
