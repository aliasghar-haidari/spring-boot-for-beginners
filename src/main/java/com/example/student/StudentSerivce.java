package com.example.student;

import java.util.List;

public interface StudentSerivce {

	List<Student> findAllStudents();

	Student save(Student s);

	Student findByEmail(String email);

	void delete(String email);

	Student update(Student s);

}
