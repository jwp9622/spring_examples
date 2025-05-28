package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardManager;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Long> {
    @Override
    ArrayList<Board> findAll(); // Iterable → ArrayList 수정

    Board findByIdx(Long idx);

    ArrayList<Board> findByBid(String bid);

    Board findByBidAndIdxAndPassword(String bid, Long idx, String Password);
}
