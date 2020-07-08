package com.training.student.studentapplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.student.studentapplication.entity.StudentEntity;
import com.training.student.studentapplication.model.Student;
import com.training.student.studentapplication.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudnetService {

	RestTemplate template = new RestTemplate();

	Map<Integer, Student> stuMap = new HashMap<>();

	@Autowired
	private StudentRepository studentRepositoty;

	@Override
	public void saveStudent(String str) {

	}

	@Override
	public void save(Student student) {
		// stuMap.put(student.getId(), student);

		StudentEntity entity = new StudentEntity();
		entity.setId(student.getId());
		entity.setAge(student.getAge());
		entity.setName(student.getName());;
		entity.setDepartment(student.getDepartment());
		
		
		studentRepositoty.save(entity);

	}

	@Override
	public List<Student> getStudentList() {
		List<StudentEntity> studnetList = studentRepositoty.findAll();
		List<Student> studentLst = new ArrayList<>();
		for (StudentEntity student : studnetList) {
			Student stdent = new  Student();
			stdent.setName(student.getName());
			stdent.setId(student.getId());
			stdent.setAge(student.getAge());
			stdent.setDepartment(student.getDepartment());
			studentLst.add(stdent);
		}

		return studentLst;
	}

	@Override
	public Student getSudentById(Integer id) {
		Optional<StudentEntity> student= studentRepositoty.findById(id);
		if(student.isPresent()) {
			StudentEntity studentEntity = student.get();
			Student stdent = new  Student();
			stdent.setName(studentEntity.getName());
			stdent.setId(studentEntity.getId());
			stdent.setAge(studentEntity.getAge());
			stdent.setDepartment(studentEntity.getDepartment());
			return stdent;
		}
		return null;
	}

	@Override
	public Student getSudentByName(String name) {

		Optional<StudentEntity> student= studentRepositoty.findByName(name);
		if(student.isPresent()) {
			StudentEntity studentEntity = student.get();
			Student stdent = new  Student();
			stdent.setName(studentEntity.getName());
			stdent.setId(studentEntity.getId());
			stdent.setAge(studentEntity.getAge());
			stdent.setDepartment(studentEntity.getDepartment());
			return stdent;
		}
		return null;
	}

	@Override
	public JSONArray getEmpDetails() {
		JSONArray result = new JSONArray();
		String response = template.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
		JSONArray array = new JSONArray(response);
		for (int i = 0; i < array.length() - 1; i++) {
			JSONObject object = array.getJSONObject(i);
			JSONObject obj = new JSONObject();
			obj.put("id", object.get("id"));
			obj.put("name", object.get("name"));
			obj.put("company_name", object.getJSONObject("company").get("name"));
			result.put(i, obj);
		}
		return result;
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepositoty.deleteById(id);
		
	}

}
