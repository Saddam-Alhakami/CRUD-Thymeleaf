package com.demo.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.thymeleaf.dao.StudentRepository;
import com.demo.thymeleaf.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
    @Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long theId) {
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteById(Long theId) {
		studentRepository.deleteById(theId);
		
	}

}
