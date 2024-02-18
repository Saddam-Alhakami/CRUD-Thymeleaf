package com.demo.thymeleaf.service;

import java.util.List;

import com.demo.thymeleaf.entity.Student;




public interface StudentService  {
	

	List<Student> findAll();
	
	Student findById(Long theId);
	
	void save(Student student);
	
	void deleteById(Long theId);

}
