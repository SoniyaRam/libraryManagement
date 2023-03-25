package com.library.libraryManagement.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Book;
import com.library.libraryManagement.repository.BookRepositoryInterf;
import com.library.libraryManagement.services.BookServiceInterf;

@Service
public class BookServiceImpl implements BookServiceInterf{
	@Autowired
	BookRepositoryInterf bookRepositoryInterf ;
	
	@Override
	public void createBook(Book book) {
		bookRepositoryInterf.save(book);
		
	}

	@Override
	public List<Book> getBooks(String genre, boolean available, String author) {
		if(genre != null || author != null) {
			return bookRepositoryInterf.findBooksByGenreAuthor(genre, author, available) ;
		} else if(genre != null) {
			return bookRepositoryInterf.findBooksByGenre(genre, available);
		} else if(author != null) {
			return bookRepositoryInterf.findBooksByAuthor(author, available);
		} else {
			return bookRepositoryInterf.findByAvailability(available);
		}	
	}
}
