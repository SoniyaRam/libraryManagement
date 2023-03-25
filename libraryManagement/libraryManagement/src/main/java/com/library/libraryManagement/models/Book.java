package com.library.libraryManagement.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.library.libraryManagement.enums.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn
	private Author author;
	
	@ManyToOne
	@JoinColumn
	private Card card;
	
	@ManyToOne
	@JoinColumn
	private Student student;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean available;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ElementCollection
	private List<Transaction> transactions;
		
	public Book() {
	}

	public Book(String name, Genre genre, Author author) {
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.available = true;
	}
			
}

