package com.sneha.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sneha.student.VO.ResponseTemplate;
import com.sneha.student.entity.Student;

@Service
public interface  StudentService  {
	
	Student add(Student std);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stdWithClg(long stdRollNo);
	Student assignCollege(long stdRollNo, long clgId);
	List<Student> getByClgId(long clg_id);
	List<Student> getStudentByCollegeWithDescAge(long clg_id);
}
