package com.example.springbasic.services;

import com.example.springbasic.dto.Book;
import org.springframework.stereotype.Service;

@Service
public class AbookService implements BookInterface{

    private Book book;

    public AbookService(Book book) {
        this.book = book;
    }

    @Override
    public void publish() {
        System.out.println(book.getName()+" 작가의 "+ book.getTitle()+" 책을 " +
                book.getPrice()+"에 출판 합니다.");
    }


}
