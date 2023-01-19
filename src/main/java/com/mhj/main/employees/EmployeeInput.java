package com.mhj.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	
	private Scanner sc;
	
	public EmployeeInput() {
		sc = new Scanner(System.in);
	}
	
	//추가
	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("추가하려는 고용인의 이름을 입력하세요.");
		employeeDTO.setFirst_name(sc.next());
		System.out.println("추가하려는 고용인의 성을 입력하세요.");
		employeeDTO.setLast_name(sc.next());
		System.out.println("추가하려는 고용인의 이메일을 입력하세요.");
		employeeDTO.setEmail(sc.next());
		System.out.println("추가하려는 고용인의 급여를 입력하세요.");
		employeeDTO.setSalary(sc.nextDouble());
		
		return employeeDTO;
	}
	
	//삭제
	public EmployeeDTO deleteData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("삭제하려는 고용인의 ID를 입력하세요.");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		return employeeDTO;
	}
	
	//수정
	public EmployeeDTO updateData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("수정하려는 고용인의 ID를 입력하세요.");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		System.out.println("수정하려는 고용인의 이메일을 입력하세요.");
		employeeDTO.setEmail(sc.next());
		System.out.println("수정하려는 고용인의 급여를 입력하세요.");
		employeeDTO.setSalary(sc.nextDouble());
		
		return employeeDTO;
		
	}
	
}
