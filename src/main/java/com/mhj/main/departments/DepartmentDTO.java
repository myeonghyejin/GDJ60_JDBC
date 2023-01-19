package com.mhj.main.departments;

public class DepartmentDTO {
	
	//모든 멤버 변수의 접근 지정자는 private
	//멤버 변수의 데이터타입과 변수명은 Table의 컬럼의 데이터타입과 컬럼명과 일치해야 함
	//변수마다 Getter, Setter 생성
	//생성자는 여러 개 있어도 상관 없지만 기본 생성자는 꼭 있어야 함
	
	//null이 들어올 가능성이 있어서 왠만하면 primitive Type보다 Reference Type으로 선언하는 게 좋음
	
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	
	
	// Getter, Setter -------------------------------------------
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
}