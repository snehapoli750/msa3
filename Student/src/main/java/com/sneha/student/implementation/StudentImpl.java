package com.sneha.student.implementation;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.web.client.RestTemplate;

	import com.sneha.student.VO.College;
	import com.sneha.student.VO.ResponseTemplate;
	import com.sneha.student.entity.Student;
	import com.sneha.student.repository.StudentRepository;
	import com.sneha.student.service.StudentService;

	@Component
	public class StudentImpl implements StudentService {

		@Autowired
		private StudentRepository stdRepo;
		
		@Autowired
		private RestTemplate restTemplate;
		
		@Override
		public Student add(Student std) {
			return stdRepo.save(std);
		}

		@Override
		public List<Student> list() {
			return stdRepo.findAll();
		}

		@Override
		public Student searchById(long rollNo) {
			return stdRepo.findById(rollNo);
		}

		@Override
		public ResponseTemplate stdWithClg(long stdrollNo) {
			ResponseTemplate RT = new ResponseTemplate();
			Student std = stdRepo.findById(stdrollNo);
			
			long clg_id = std.getClg_id();
			College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clg_id,College.class);
			RT.setCollege(clg);
			RT.setStudent(std);
			return RT;
		}

		@Override
		public Student assignCollege(long stdRollNo, long clgId) {
			Student std= stdRepo.findById(stdRollNo);
			College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clgId, College.class);
			if(std==null || clg==null)
			{
				return null;
			}
			std.setClg_id(clgId);
			stdRepo.save(std);
			return std;
		}

		@Override
		public List<Student> getByClgId(long clg_id) {
			return stdRepo.getByClgId(clg_id);
		}

		@Override
		public List<Student> getStudentByCollegeWithDescAge(long clg_id) {
			return stdRepo.getStudentByCollegeWithDescAge(clg_id);
		}
		

	}
