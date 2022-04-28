package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> findAll();
	void saveStudent(Student s);
	void editStudent(Student s);
	Student getStudentById(long id);
	void StudentDelete(Long id);
}
