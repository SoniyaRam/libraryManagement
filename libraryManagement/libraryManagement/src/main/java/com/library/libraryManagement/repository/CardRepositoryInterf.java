package com.library.libraryManagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.library.libraryManagement.models.Card;

public interface CardRepositoryInterf extends JpaRepository<Card, Integer>{

		@Modifying
		@Transactional
		@Query(value = "update card c set c.card_status = "
				+ ":status where c.id in (select card_id from student s where s.id = :student_id)"
				, nativeQuery = true)
		void deactivateCard(int student_id, String status);

		void save(Card card);
	}