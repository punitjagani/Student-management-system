package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
		
	}

	@Override
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		studentrepository.save(s);
	}

	@Override
	public void editStudent(Student s) {
		// TODO Auto-generated method stub
		studentrepository.save(s);
	}

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		return studentrepository.getById(id);
	}

	@Override
	public void StudentDelete(Long id) {
		// TODO Auto-generated method stub
		studentrepository.deleteById(id);
	}

}
