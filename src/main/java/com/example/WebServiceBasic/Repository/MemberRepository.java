package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByIdx(Long idx);
    Optional<Member> findByUsername(String username);
}
