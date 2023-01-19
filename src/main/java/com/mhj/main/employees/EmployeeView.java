package com.mhj.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	//전체 사원
	public void view(EmployeeDTO employeeDTO) {
		System.out.println("Employee ID    : " + employeeDTO.getEmployee_id());
		System.out.println("First Name     : " + employeeDTO.getFirst_name());
		System.out.println("Last Name      : " + employeeDTO.getLast_name());
		System.out.println("Email          : " + employeeDTO.getEmail());
		System.out.println("Phone Number   : " + employeeDTO.getPhone_number());
		System.out.println("Hire Date      : " + employeeDTO.getHire_date());
		System.out.println("Job ID         : " + employeeDTO.getJob_id());
		System.out.println("Salary         : " + employeeDTO.getSalary());
		System.out.println("Commission PCT : " + employeeDTO.getCommission_pct());
		System.out.println("Manager ID     : " + employeeDTO.getManager_id());
		System.out.println("Department ID  : " + employeeDTO.getDepartment_id());
		System.out.println("==================================");
	}
	
	//개별 사원
	public void view(ArrayList<EmployeeDTO> ar) {
		for (EmployeeDTO employeeDTO:ar) {
			this.view(employeeDTO);
		}
	}
	
	//메시지 출력
	public void view(String msg) {
		System.out.println(msg);
	}

}
