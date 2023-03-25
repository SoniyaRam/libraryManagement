package com.library.libraryManagement.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Card;
import com.library.libraryManagement.models.Student;
import com.library.libraryManagement.repository.StudentRepositoryInterf;
import com.library.libraryManagement.services.CardServiceInterf;
import com.library.libraryManagement.services.StudentServiceInterf;

@Service
public class StudentServiceImpl implements StudentServiceInterf {
	
	private static Logger logger = LoggerFactory.getLogger(StudentServiceInterf.class);

	@Autowired
	CardServiceInterf cardServiceInterf;
	@Autowired
	StudentRepositoryInterf studentRepositoryInterf;
	
	public void createStudent(Student student) {
		Card newCard = cardServiceInterf.createAndReturn(student);
		logger.info("The card for the student {} is created with the details - {}",student, newCard);
	}
	
	public void updateStudent(Student student) {
		studentRepositoryInterf.updateStudentDetails(student);
	}
	
	public void deleteStuden(int id) {
		cardServiceInterf.deactivateCard(id);
		studentRepositoryInterf.deleteCustom(id);
	}
}