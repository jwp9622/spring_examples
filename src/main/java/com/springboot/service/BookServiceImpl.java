package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() {
		
		return bookRepository.getAllBookList();
	}

}
