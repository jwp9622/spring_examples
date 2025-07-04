package com.example.springbasic.services;

import com.example.springbasic.dto.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment){
        logger.info("내용 "+comment.getContent());
        return "SUCCESS";

    }

}
