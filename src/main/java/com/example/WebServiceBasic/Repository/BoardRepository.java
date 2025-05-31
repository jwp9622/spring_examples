package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Long> {
    @Override
    ArrayList<Board> findAll(); // Iterable → ArrayList 수정

    Optional<Board> findByIdx(Long idx);

    Optional<Board> findByBidAndIdx(String bid, Long idx);

    ArrayList<Board> findByBid(String bid);

    Board findByBidAndIdxAndPassword(String bid, Long idx, String Password);

    ArrayList<Board> findByBidTitle(String bid, String keyword);
}
