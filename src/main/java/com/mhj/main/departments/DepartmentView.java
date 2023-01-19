package com.mhj.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	
	//view
	
	//전체 출력
	public void view(ArrayList<DepartmentDTO> ar) {
		for (DepartmentDTO departmentDTO:ar) {
			this.view(departmentDTO);
		}
	}
	
	//1개 출력
	public void view(DepartmentDTO departmentDTO) {
		System.out.println("Department ID   : " + departmentDTO.getDepartment_id());
		System.out.println("Department Name : " + departmentDTO.getDepartment_name());
		System.out.println("Manager ID      : " + departmentDTO.getManager_id());
		System.out.println("Location ID     : " + departmentDTO.getLocation_id());
		System.out.println("==================================");
	}
	
	//메시지 출력
	public void view(String msg) {
		System.out.println(msg);
	}

}