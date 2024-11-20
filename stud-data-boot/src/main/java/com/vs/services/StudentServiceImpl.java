package com.vs.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.entity.Student;
import com.vs.repo.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	
	@Override
	public void save(Student s) {
		repo.save(s);

	}

	@Override
	public Student fetch(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Student> list() {
		
		return repo.findAll();
	}

	@Override
	public void remove(int id) {
		
		repo.deleteById(id);

	}

	@Override
	public List<Student> fetchAllByName(String name) {
		
		return repo.findByStudName(name);
	}

	@Override
	public List<Student> fetchAllByDate(LocalDate d) {
		
		return repo.findByAdmDate(d);
	}

	@Override
	public List<Student> fetchAllBySectionAndMarks(String Section, double mar) {
	    return repo.findBySectionAndMarks(Section, mar);
	}


}
