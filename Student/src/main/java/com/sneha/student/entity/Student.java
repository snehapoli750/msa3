package com.sneha.student.entity;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table

public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long rollNo;
		private String name;
		private String gender;
		private int age;
		
		public long getRollNo() {
			return rollNo;
		}
		public void setRollNo(long rollNo) {
			this.rollNo = rollNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
		
		public Student(String name,  String gender, int age) {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
		}
		public Student(long rollNo, int age, String gender, String name) {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Student [rollNo=" + rollNo + ", name=" + name + ", gender=" + gender + ", age=" + age
					+ "]";
		}
		public void setClg_id(long clgId) {
			// TODO Auto-generated method stub
			
		}
		public long getClg_id() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
