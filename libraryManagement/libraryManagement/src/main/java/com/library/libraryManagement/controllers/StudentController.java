package com.library.libraryManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryManagement.models.Student;
import com.library.libraryManagement.services.StudentServiceInterf;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@PostMapping("/createStudent")
	public ResponseEntity createStudent(@RequestBody Student student ) {
		studentServiceInterf.createStudent(student);
		return new ResponseEntity<>("Student is created successfully",HttpStatus.CREATED);
	}	
		@PutMapping("/updateStudent")
		public ResponseEntity UpdateStudent(@RequestBody Student student ) {
			studentServiceInterf.updateStudent(student);
			return new ResponseEntity<>("Student is updated successfully",HttpStatus.ACCEPTED);
	}
		@DeleteMapping("/deleteStudent")
		public ResponseEntity deleteStudent(@RequestParam("id") int id) {
			studentServiceInterf.deleteStuden(id);
			return new ResponseEntity<>("Student is deleted successfully",HttpStatus.ACCEPTED);
		
}
}
