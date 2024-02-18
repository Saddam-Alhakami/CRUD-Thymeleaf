package com.demo.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.thymeleaf.entity.Student;

public interface StudentRepository extends JpaRepository<Student,  Long> {

}
