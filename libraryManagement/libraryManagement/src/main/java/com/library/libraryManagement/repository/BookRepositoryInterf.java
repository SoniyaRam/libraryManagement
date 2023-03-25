package com.library.libraryManagement.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.library.libraryManagement.models.Book;

public interface BookRepositoryInterf extends Repository<Book, Integer> {
	
	@Query("select b from Book b where b.available =:availability and b.author in (select a from Author a where a.name =:author_name)")
	List<Book> findBooksByAuthor(String author_name, boolean availability);
	
	
	@Query("select b from Book b where b.genre =:genre and b.available =:availability")
	List<Book> findBooksByGenre(String genre, boolean availability);
	
	@Query("select b from Book b where b.available =:availability and b.genre =:genre and b.author in (select a from Author a where a.name =:author_name)")
	List<Book> findBooksByGenreAuthor(String genre, String author, boolean availability);
	
	@Query("select b from Book b where b.available =:availability")
	List<Book> findByAvailability(boolean availability);
	
	@Modifying
	@Transactional
	@Query("update Book b set b.available =:#{#book.available}, b.student=:#{#book.student} where b.id =:#{#book.id}")
	int updateBook(Book book);


	void save(Book book);
}
