package com.example.springbasic.main;

import com.example.springbasic.config.AppConfig;
import com.example.springbasic.dto.Book;
import com.example.springbasic.services.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//6. JavaConfig를 사용한 빈 설정
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var book = context.getBean(Book.class);

        var bookservice = context.getBean(BookService.class);
        bookservice.publish();

        book.setPrice(20000);
        bookservice.publish();

    }
}

