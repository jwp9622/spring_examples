package com.example.springbasic.services;

import com.example.springbasic.dto.Book;

public class BookService {
    private Book book;

    public BookService(Book book){
        this.book = book;
    }
    public void publish(){
        System.out.println(book.getName()+", "+book.getTitle()+", "+
                book.getPrice());
    }
}
