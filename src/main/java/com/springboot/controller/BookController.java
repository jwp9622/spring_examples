
package com.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.domain.Book;
import com.springboot.service.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}	

	
	@GetMapping("/all")   
	public ModelAndView requestAllBooks() {
		ModelAndView modelAndView = new ModelAndView(); 
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList", list); 
		modelAndView.setViewName("books"); 
		return modelAndView;
	}
	
	
}
