package com.example.springbasic.main;

import com.example.springbasic.aspect.UserAspect;
import com.example.springbasic.config.AppConfig;
import com.example.springbasic.dto.Comment;
import com.example.springbasic.services.CommentService;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//8. AOP를 사용하여 애스펙트 구현하기
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setName("홍길동---");
        comment.setContent("안녕하세요--");

        String returnedValue = service.publishComment(comment);

        logger.info(returnedValue);

    }
}

