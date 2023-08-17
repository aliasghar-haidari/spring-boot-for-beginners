package com.example.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentSerivce {
	
	public List<Student> findAllStudents() {

		return List.of(new Student("Ali Agha", "Karimi", LocalDate.now(), "alikarimi@gmail.com", 29),

				new Student("Mohammad", "Naderi", LocalDate.now(), "mohamdi@outlook.com", 41));
	}

}
