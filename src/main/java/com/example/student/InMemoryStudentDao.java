package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Repository

public class InMemoryStudentDao{


	private final List<Student> STUDENTS = new ArrayList<>();

	public List<Student> findAllStudents() {
		return STUDENTS;
	}

	public Student save(Student s) {
		STUDENTS.add(s);
		return s;
	}

	public Student findByEmail(String email) {
		return STUDENTS.stream().filter(s -> email.equals(s.getEmail())).findFirst().orElse(null);
	}

	public void delete(String email) {
		var student = findByEmail(email);
		if (student != null) {
			STUDENTS.remove(email);
		}
	}

	public Student update(Student s) {
		var studentIndex = IntStream.range(0, STUDENTS.size())
				.filter(index -> STUDENTS.get(index).getEmail().equals(s.getEmail())).findFirst().orElse(-1);
		if (studentIndex > -1) {
			STUDENTS.set(studentIndex, s);
			return s;
		}
		return null;
	}
	

}
