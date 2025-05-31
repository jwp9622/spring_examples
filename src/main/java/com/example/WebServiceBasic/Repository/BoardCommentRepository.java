package com.example.WebServiceBasic.Repository;

import com.example.WebServiceBasic.Entity.Board;
import com.example.WebServiceBasic.Entity.BoardComment;
import com.example.WebServiceBasic.Entity.BoardManager;
import org.springframework.data.repository.CrudRepository;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BoardCommentRepository extends CrudRepository<BoardComment, Long > {

    List<BoardComment> findByBoardIdx(Long boardIdx);

    Optional<BoardComment> findByIdx(Long idx);

    List<BoardComment> findByBoardIdxAndNickname(Long boardIdx, String nickName);

    Optional<BoardComment> findByBoardIdxAndIdx(Long boardIdx, Long idx);

}
