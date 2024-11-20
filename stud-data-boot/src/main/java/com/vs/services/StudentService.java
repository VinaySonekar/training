package com.vs.services;

import java.time.LocalDate;
import java.util.List;

import com.vs.entity.Student;

public interface StudentService {

	public void save(Student s);
	
	public Student fetch(int id);
	
	public List<Student> list();
	
	public void remove(int id);
	
	public  List<Student> fetchAllByName(String name);
	
	public  List<Student> fetchAllByDate(LocalDate d);
	
	public  List<Student> fetchAllBySectionAndMarks(String Section, double mar);
	
	
}
