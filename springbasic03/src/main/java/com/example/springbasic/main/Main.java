package com.example.springbasic.main;

import com.example.springbasic.config.AppConfig;
import com.example.springbasic.services.AbookService;
import com.example.springbasic.services.Book;
import com.example.springbasic.services.BookManagerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//3. Qualifier를 사용하여 동일한 타입의 빈 주입 제어하기
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var manager = context.getBean(BookManagerService.class);

        var book = context.getBean(Book.class);

        book.setName("남주");
        book.setTitle("우리생의 순간");
        book.setPrice(20000);

        manager.process();



    }
}

