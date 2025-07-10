package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
