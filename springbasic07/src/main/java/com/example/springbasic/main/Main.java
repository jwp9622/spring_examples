package com.example.springbasic.main;

import com.example.springbasic.dto.Book;
import com.example.springbasic.services.AbookService;
import com.example.springbasic.services.BbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

//7. 인터페이스를 사용하여 의존성 주입하기
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var book = new Book();
        book.setName("Tomas");
        book.setTitle("Greet");
        book.setPrice(10000);

        var abookService = new AbookService(book);
        abookService.publish();


        book.setName("Santec");
        book.setTitle("Little prince");
        book.setPrice(20000);

        var bbookService = new BbookService(book);
        bbookService.publish();



    }
}

