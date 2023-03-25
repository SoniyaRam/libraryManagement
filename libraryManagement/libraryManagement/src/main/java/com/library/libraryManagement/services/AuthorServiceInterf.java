package com.library.libraryManagement.services;

import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Author;

@Service
public interface AuthorServiceInterf{
	
	void createAuthor(Author author);
	
	

}
