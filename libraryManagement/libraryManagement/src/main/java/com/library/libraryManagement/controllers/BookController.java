package com.library.libraryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.library.libraryManagement.models.Book;
import com.library.libraryManagement.services.BookServiceInterf;

@RestController
public class BookController {
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@PostMapping("/createBook")
	public ResponseEntity createBook(@RequestBody Book book) {
		bookServiceInterf.createBook(book);
		return new ResponseEntity<>("Book is created successfully ",HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getBooks")
	public ResponseEntity getBooks(@RequestParam (value="genre", required = false)String genre ,
	@RequestParam (value="available",required = false, defaultValue = "false") boolean available,
	@RequestParam (value="author", required = false)String author){
		
		List<Book> bookList = bookServiceInterf.getBooks(genre, available, author);
		return new ResponseEntity<>("bookList",HttpStatus.OK);
}
}