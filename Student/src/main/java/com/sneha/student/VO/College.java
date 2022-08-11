package com.sneha.student.VO;

public class College {
		private long id;
		private String name;
		private int totalStds;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getTotalStds() {
			return totalStds;
		}
		public void setTotalStds(int totalStds) {
			this.totalStds = totalStds;
		}
		public College(String name, int totalStds) {
			super();
			this.name = name;
			this.totalStds = totalStds;
		}
		public College() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
