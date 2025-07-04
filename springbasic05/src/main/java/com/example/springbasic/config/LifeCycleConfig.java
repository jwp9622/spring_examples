package com.example.springbasic.config;

import com.example.springbasic.dto.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfig {

    //@Bean(initMethod = "init", destroyMethod = "close")
    @Bean
    public Book book(){
        Book book = new Book();
        System.out.println("Book Bean Call");
        return book;
    }


}
