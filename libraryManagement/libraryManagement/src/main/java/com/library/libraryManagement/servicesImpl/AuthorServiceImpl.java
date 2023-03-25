package com.library.libraryManagement.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Author;
import com.library.libraryManagement.repository.AuthorRepositoryInterf;
import com.library.libraryManagement.services.AuthorServiceInterf;
@Service
public class AuthorServiceImpl implements AuthorServiceInterf {

	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;
	
	@Override
	public void createAuthor(Author author) {
	 authorRepositoryInterf.save(author);
		
	}

}
