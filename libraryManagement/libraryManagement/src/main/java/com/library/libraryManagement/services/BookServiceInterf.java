package com.library.libraryManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Book;

@Service
public interface BookServiceInterf {

	void createBook(Book book);
	
	List<Book> getBooks(String genre, boolean available, String author);
}
