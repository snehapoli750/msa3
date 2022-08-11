package com.sneha.college.VO;

public class Student {

			private long rollNo;
			private String name;
			private String gender;
			private int age;
			
			
			public long getRollNO() {
				return rollNo;
			}
			public void setRollNO(long rollNo) {
				this.rollNo = rollNo;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
			
			public Student(String name, String gender, int age) {
				super();
				this.name = name;
				this.gender = gender;
				this.age = age;
			}
			public Student() {
				super();
			}
	}

