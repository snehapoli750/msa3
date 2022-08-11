package com.sneha.student.VO;



import com.sneha.student.entity.Student;

public class ResponseTemplate {

	private Student student;
	private College college;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public College getDepartment() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public ResponseTemplate(Student student, College college) {
		super();
		this.student = student;
		this.college = college;
	}
	public ResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
