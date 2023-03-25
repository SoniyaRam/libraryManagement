package com.library.libraryManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.library.libraryManagement.models.Student;

	public interface StudentRepositoryInterf extends JpaRepository<Student, Integer>{

		@Modifying
		@Query(value = "update student c set c.studentStatus = :Status where c.id in "
				+ "(select student_id from student s where s.id = :student_id)", nativeQuery = true)
		void deactivateStudent(int student_id, String status);
		
		
		@Modifying
		@Query("update Student s set s.emailId = :#{#std.emailId}, " + 
				"s.name = :#{#std.name}, " +
				"s.age = :#{#std.age}, " +
				"s.country = :#{#std.country} " +
				"where s.id = :#{#std.id}")
		int updateStudentDetails(Student std);
		
		@Modifying
		@Query(value = "delete from Student s where s.id =:id")
		void deleteCustom(int id);


	void save(Student student);
	}


