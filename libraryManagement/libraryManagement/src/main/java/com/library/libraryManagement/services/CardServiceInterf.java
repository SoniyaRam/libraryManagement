package com.library.libraryManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryManagement.enums.CardStatus;
import com.library.libraryManagement.models.Card;
import com.library.libraryManagement.models.Student;
import com.library.libraryManagement.repository.CardRepositoryInterf;

@Service
public class CardServiceInterf {

		@Autowired
		CardRepositoryInterf cardRepositoryInterf;
		
		public Card createAndReturn(Student student) {
			Card card = new Card();
			card.setStudent(student);
			student.setCard(card);
			
			cardRepositoryInterf.save(card);
			
			return card;
		}
		
		public void deactivateCard(int student_id) {
			cardRepositoryInterf.deactivateCard(student_id, CardStatus.DEACTIVATE.toString()); 
		}
	}
