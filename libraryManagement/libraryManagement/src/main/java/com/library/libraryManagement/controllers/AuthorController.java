package com.library.libraryManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryManagement.models.Author;
import com.library.libraryManagement.services.AuthorServiceInterf;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorServiceInterf authorServiceInterf;
	
	
	@PostMapping("/createAuthor")
	public ResponseEntity createAuthor(@RequestBody Author author) {
	authorServiceInterf.createAuthor(author);
	return new ResponseEntity<>("Author is created",(HttpStatus.CREATED));
}
}