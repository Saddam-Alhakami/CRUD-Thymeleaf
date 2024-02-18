package com.demo.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.thymeleaf.entity.Student;
import com.demo.thymeleaf.service.StudentService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/students")
public class StudentControl {
	
	private StudentService studentService;
    
	@Autowired
	public StudentControl(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/list")
	public String showStudents(Model model) {
		
		List<Student> students=studentService.findAll();
		model.addAttribute("students", students);
		
		return "students-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("student",new Student());

		
		
		return "Show-Form-For-Add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute ("student") Student student,Model model) {
		
		studentService.save(student);
		List<Student> students=studentService.findAll();
		model.addAttribute("students", students);
		
		return "students-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("studentId") Long id,Model model) {
		
		Student student=studentService.findById(id);
		model.addAttribute("student",student);
		
		
		return "Show-Form-For-Add";
	}
	
	@GetMapping("/delete")
	public  String deleteEmployee(@RequestParam("studentId") Long id,Model model) {
		
		
		studentService.deleteById(id);
		List<Student> students=studentService.findAll();
		model.addAttribute("students", students);
		
	return "students-form";		
		
		
		
	}
	
	

}
