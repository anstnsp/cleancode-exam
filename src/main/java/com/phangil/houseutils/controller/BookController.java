package com.phangil.houseutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phangil.houseutils.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/{isbn}")
	public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
		return bookService.getBookNameByIsbn(isbn);
	}

}
