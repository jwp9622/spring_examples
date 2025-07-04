package com.example.springbasic.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Bbook")
public class BbookService implements BookInterface{
    private Book book;

    public BbookService(Book book){
        this.book = book;
    }
    @Override
    public void publish() {
        System.out.println("B책의 "+book.getName()+" 작가의 "+ book.getTitle()+" 책을 " +
                book.getPrice()+"에 출판 합니다.");
    }

}
