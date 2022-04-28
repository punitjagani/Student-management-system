package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.findAll());
		System.out.print("student");
		return "students";
	}
	
	@GetMapping("/form")
	public String openForm(Model model) {
		Student student=new Student();
		model.addAttribute(student);
		return "form";
	}
	
	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		System.out.print(student);
		return "redirect:/students";	
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		 model.addAttribute("student",studentService.getStudentById(id));
		 //studentService.editStudent(student);
		 System.out.println(studentService.getStudentById(id).getEmail());
		 return "edit";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student) {
		Student existingStudent= studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		System.out.print(existingStudent);
		studentService.editStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.StudentDelete(id);
		return "redirect:/students";
	}
}
