package com.sneha.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sneha.college.VO.RequestTemplate;
import com.sneha.college.entity.College;
@Service
public interface CollegeService {
	
	
	College update(long id,String name);
	
	
	

	College add(College clg);
	List<College> list();
	College searchById(long id);

	List<RequestTemplate> listWithStd();


	RequestTemplate specificClgStudent(long clg_id);



}
