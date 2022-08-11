package com.sneha.student.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.sneha.student.VO.ResponseTemplate;
	import com.sneha.student.entity.Student;
	import com.sneha.student.service.StudentService;

	@RestController
	@RequestMapping("/student")
	public class StudentController {
		
		@Autowired
		StudentService stdService;
		
		@PostMapping
		public Student add(@RequestBody Student std)
		{
			return stdService.add(std);
		}
		
		@GetMapping
		public List<Student> liststd(){
			return stdService.list();
		}
		
		@GetMapping("/{stdrollNo}")
		public ResponseTemplate stdWithClg(@PathVariable long stdrollNo)
		{
			return stdService.stdWithClg(stdrollNo);
		}
		
		@PutMapping("/{stdrollNo}/{clgId}")
		public String updateStudent(@PathVariable long stdrollNo,@PathVariable long clgId)
		{
			Student std = stdService.assignCollege(stdrollNo,clgId);
			if(std!=null)
			{
				return std.toString();
			}
			return "Sorry. College or Student Not Found";
		}
		
		@GetMapping("/student-with-ascname/{clg_id}")
		public List<Student> getByClgId(@PathVariable long clg_id)
		{
			return stdService.getByClgId(clg_id);
		}
		
		@GetMapping("/student-with-desc-age/{clg_id}")
		public List<Student> getStudentByCollegeWithDescAge(@PathVariable long clg_id)
		{
			return stdService.getStudentByCollegeWithDescAge(clg_id);
		}
	}







