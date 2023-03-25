package com.library.libraryManagement.repository;

import org.springframework.data.repository.Repository;

import com.library.libraryManagement.models.Author;

public interface AuthorRepositoryInterf extends Repository<Author, Integer> {

	void save(Author author);

}
