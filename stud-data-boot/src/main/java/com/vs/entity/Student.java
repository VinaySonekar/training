package com.vs.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="Stud")
public class Student {
	
	@Id
	
	@Column(name="roll_no")
	private int rollNo;
	@Column(name="Student_Name", length=30)
	@NotBlank(message="Name is Mandatory")
	private String StudName;
	
	@Column(length=20)
	private String Section;
	
	@Column(name="Student_Marks")
	private double marks;
	
	@Column(name="Admission date")
	private LocalDate AdmDate;
	
	
	
	
	
	public Student(int rollNo, String studName, String section, double marks, LocalDate admDate) {
		super();
		this.rollNo = rollNo;
		StudName = studName;
		Section = section;
		this.marks = marks;
		AdmDate = admDate;
	}


	public Student() {
		
	}


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getStudName() {
		return StudName;
	}


	public void setStudName(String studName) {
		StudName = studName;
	}


	public String getSection() {
		return Section;
	}


	public void setSection(String section) {
		Section = section;
	}


	public double getMarks() {
		return marks;
	}


	public void setMarks(double marks) {
		this.marks = marks;
	}


	public LocalDate getAdmDate() {
		return AdmDate;
	}


	public void setAdmDate(LocalDate admDate) {
		AdmDate = admDate;
	}

	
	

}
