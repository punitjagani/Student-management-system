package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;
//we dont have to add transaciton and repository annotation becuase JPA provides that
public interface StudentRepository extends JpaRepository<Student, Long>{

	
}
