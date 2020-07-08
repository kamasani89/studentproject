package com.training.student.studentapplication.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.student.studentapplication.service.StudnetService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
		@Autowired 
		private StudnetService studetnService;
	
	
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public List<Object> getResult(){
			JSONArray array = studetnService.getEmpDetails();
			return array.toList();
		}
}
