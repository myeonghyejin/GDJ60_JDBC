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
		System.out.println("추가하려는 고용인의 휴대 전화 번호를 입력하세요.");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("추가하려는 고용인의 입사일을 입력하세요.");
		employeeDTO.setHire_date(sc.next());
		System.out.println("추가하려는 고용인의 직군을 입력하세요.");
		employeeDTO.setJob_id(sc.next());
		System.out.println("추가하려는 고용인의 급여를 입력하세요.");
		employeeDTO.setSalary(sc.nextDouble());
		System.out.println("추가하려는 고용인의 수당률을 입력하세요.");
		employeeDTO.setCommission_pct(sc.nextDouble());
		System.out.println("추가하려는 고용인의 직속상관의 사번을 입력하세요.");
		employeeDTO.setManager_id(sc.nextInt());
		System.out.println("추가하려는 고용인의 부서 번호를 입력하세요.");
		employeeDTO.setDepartment_id(sc.nextInt());
		
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
