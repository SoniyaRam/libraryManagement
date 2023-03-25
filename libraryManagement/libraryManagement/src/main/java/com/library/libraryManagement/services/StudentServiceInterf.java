package com.library.libraryManagement.services;

import org.springframework.stereotype.Service;

import com.library.libraryManagement.models.Student;

@Service
public interface StudentServiceInterf {

	void createStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStuden(int id);
}
