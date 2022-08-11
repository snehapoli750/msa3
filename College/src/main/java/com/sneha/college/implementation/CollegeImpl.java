package com.sneha.college.implementation;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Component;
	import org.springframework.web.client.RestTemplate;

	import com.sneha.college.VO.Student;
	import com.sneha.college.VO.RequestTemplate;
	import com.sneha.college.entity.College;
	import com.sneha.college.repository.CollegeRepository;
	import com.sneha.college.service.CollegeService;

	@Component
	public class CollegeImpl implements CollegeService {

		@Autowired
		CollegeRepository clgRepo;
		@Autowired
		RestTemplate restTemplate;
		
		@Override
		public College add(College clg) {
			return clgRepo.save(clg);
		}

		@Override
		public List<College> list() {
			return clgRepo.findAll();
		}

		@Override
		public College update(long id, String name) {
			College clg = clgRepo.findById(id);
			clg.setName(name);
			return clgRepo.save(clg);
		}

		@Override
		public College searchById(long id) {
			if(clgRepo.findById(id)==null)
			{
				return null;
			}
			return clgRepo.findById(id);
		}

		@Override
		public List<RequestTemplate> listWithStd() {
			List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
			List<College> allClg = this.list();
			Iterator<College> ir = allClg.iterator();
			while(ir.hasNext())
			{
				College clg = ir.next();
				ResponseEntity<Student[]> response =
						  restTemplate.getForEntity(
								  "http://STUDENT-SERVICE/student/student-with-ascname/"+clg.getId(),
						  Student[].class);
				Student[] Students = response.getBody();
				List<Student> stds = Arrays.asList(Students);
	 			RequestTemplate RTm = new RequestTemplate();
				RTm.setCollege(clg);
				RTm.setStudentList(stds);
				fullList.add(RTm);
			}
			return fullList;
		}

		@Override
		public RequestTemplate specificClgStudent(long clg_id) {
			College college  = this.searchById(clg_id);
			
			ResponseEntity<Student[]> response =
					  restTemplate.getForEntity(
							  "http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(),
							  Student[].class);
			 Student[] student = response.getBody();
			List<Student> students = Arrays.asList(student);
			RequestTemplate requestTemplate = new RequestTemplate();
			
			requestTemplate.setCollege(college);
			requestTemplate.setStudentList(students);
			
			return requestTemplate;
		}

	}

