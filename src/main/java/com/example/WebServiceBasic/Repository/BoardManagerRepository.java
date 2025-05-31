package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BoardManagerRepository extends CrudRepository<BoardManager, Long> {

    @Override
    ArrayList<BoardManager> findAll();

    Optional<BoardManager> findByBid(String bid);

    /*
    User findByIdAfter(Long id);
    User findByIdGreaterThan(Long id);
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();

    List<User> findByNameIs(String name);
    List<User> findByNameEquals(String name);

    List<User> findByNameIsNull();
    List<User> findByNameIsNotNull();

    * fineByUsername(String name) ==> where username = ?
    * fineByAgeGraterThan(int age) ==> where age > ?
    * findByEmailContaining(String k) ==> where email like %k%
    * findByUsernameAndAge ==> where user =? and age =?
    * */



}
