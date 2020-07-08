package com.training.student.studentapplication.service;

import java.util.List;

import org.json.JSONArray;

import com.training.student.studentapplication.model.Student;

public interface StudnetService {
	public void saveStudent(String str);

	public void save(Student student);

	public List<Student> getStudentList();

	public Student getSudentById(Integer id);

	public Student getSudentByName(String name);

	public JSONArray getEmpDetails();

	public void deleteStudentById(Integer id);
}
