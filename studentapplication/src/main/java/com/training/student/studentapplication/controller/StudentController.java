package com.training.student.studentapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.student.studentapplication.model.Student;
import com.training.student.studentapplication.service.StudnetService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired 
	private StudnetService studetnService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveStudent(@RequestBody Student student) {
		
		studetnService.save(student);
		return "success";
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Student> studentList(){
		return  studetnService.getStudentList();
		
	}
	
	@GetMapping("/get-student-by-id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student getStudentById(@PathVariable("id") Integer id){
		return  studetnService.getSudentById(id);
		
	}
	
	
	@GetMapping("/get-student-by-name")
	@ResponseStatus(HttpStatus.OK)
	public Student getStudentById(@RequestParam("name") String name){
		return  studetnService.getSudentByName(name);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudent(@PathVariable("id") Integer id) {
		studetnService.deleteStudentById(id);
		
	}
	
	
	
	
}
