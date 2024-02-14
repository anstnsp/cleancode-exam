package com.phangil.houseutils.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


	@GetMapping("/testtest")
	public PP getBookNameByIsbn22() {
		PP pp = new PP("test");
		return pp;
	}

	@PostMapping(value = "test", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> asefs(@RequestBody String metadata) {
		System.out.println("metadata:" + metadata);
		return ResponseEntity.ok("Success");
	}

}
