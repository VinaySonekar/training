package com.vs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import com.vs.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("FROM Student WHERE StudName = :nm")
	List<Student> findByStudName(@Param("nm")String name);
	
	@Query("FROM Student WHERE AdmDate = :dt")
	List<Student> findByAdmDate(@Param("dt") LocalDate d);
	

	@Query("SELECT s FROM Student s WHERE s.Section = ?1 AND s.marks = ?2")
	List<Student> findBySectionAndMarks(String Section, double marks);


//	@Query("from Student s where s.section=?1 and s.marks=?2")
//	List<Student> findBySectionAndMarks(String sec, double marks);


	
	
}
