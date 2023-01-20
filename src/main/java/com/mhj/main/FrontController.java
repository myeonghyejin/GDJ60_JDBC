package com.mhj.main;

import java.util.Scanner;

import com.mhj.main.departments.DepartmentController;
import com.mhj.main.employees.EmployeeController;
import com.mhj.main.locations.LocationController;

public class FrontController {
	
	private Scanner sc;
	private DepartmentController departmentController;
	private LocationController locationController;
	private EmployeeController employeeController;
	
	public FrontController() {
		this.sc = new Scanner(System.in);
		this.departmentController = new DepartmentController();
		this.locationController = new LocationController();
		this.employeeController = new EmployeeController();
	}
	
	public void start() throws Exception {
		boolean check = true;
		while (check) {
			System.out.println("1. 부서 관리");
			System.out.println("2. 지역 관리");
			System.out.println("3. 사원 관리");
			System.out.println("4. 종    료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				this.departmentController.start();
				break;
			case 2:
				this.locationController.start();
				break;
			case 3:
				this.employeeController.start();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("오류입니다. 다시 선택해 주세요.");
			}
		}
	}

}
