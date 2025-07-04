package com.example.springbasic.config;

import com.example.springbasic.dto.Book;
import com.example.springbasic.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book newbook(){
        Book book = new Book();
        book.setName("스테판 셰퍼");
        book.setTitle("나에게 남은 스물다섯번의 계절");
        book.setPrice(25000);
        return book;

    }
    @Bean
    public BookService bookService(){
        return new BookService( newbook() );
    }

}
