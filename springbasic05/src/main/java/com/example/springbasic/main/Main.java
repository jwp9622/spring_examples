package com.example.springbasic.main;

import com.example.springbasic.config.LifeCycleConfig;
import com.example.springbasic.dto.Book;
import com.example.springbasic.services.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//5. 빈 라이프사이클 메서드 활용하기
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        var book = context.getBean(Book.class);

        book.setName("홍길동");
        book.setTitle("우리들의 이야기");
        book.setPrice(20000);
        book.publish();

        book.close();


    }
}

