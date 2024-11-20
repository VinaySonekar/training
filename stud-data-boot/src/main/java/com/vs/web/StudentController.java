package com.vs.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vs.entity.Student;

import com.vs.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(value="/save", consumes="application/json")
	public String saveStudent(@Valid @RequestBody Student s) {
		service.save(s);
		return "Student saved successfully!";
	}
	
//	@PostMapping(value = "/create", consumes = "application/json")
//	public ResponseEntity<?> createUser(@Valid @RequestBody Student student, BindingResult result) {
//	    if (result.hasErrors()) {
//	        return ResponseEntity.badRequest().body(result.getAllErrors());
//	    }
//	    Student savedUser = service.save(student);
//	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//	}
	
	@GetMapping(value="/fetch/{id}",produces="application/json")
	public Student getStudent(@PathVariable("id") int id){
		return service.fetch(id);
	}
	
	@GetMapping(value="/list",produces="application/json")
	public List<Student> getAllStudent(){
		return service.list();
	}
	
	@GetMapping(value="/delete/{id}",produces="application/json")
	public String removeStudent(@PathVariable("id") int id){
		service.remove(id);
		return "Student Deleted Successfully";
	}
	
	@GetMapping(value="/findbyname/{name}",produces="application/json")
	public List<Student> findStudent(@PathVariable("name") String name){
		
		return service.fetchAllByName(name);
	}
	
	@GetMapping(value="/findbydate/{dt}",produces="application/json")
	public List<Student> findStudent(@PathVariable("dt") LocalDate dt){
		
		return service.fetchAllByDate(dt);
	}
	
	@GetMapping(value = "/findbySecandMar/{Section}/{marks}", produces = "application/json")
	public List<Student> findStudentBySecAndMar(@PathVariable String Section, @PathVariable double marks) {
	    return service.fetchAllBySectionAndMarks(Section, marks);
	}

	
	
	
	
	
}
