package com.mhj.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

import com.mhj.main.departments.DepartmentDAO;

public class EmployeeController {

	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeInput employeeInput;
	
	public EmployeeController() {		
		this.sc = new Scanner(System.in);
		this.employeeDAO = new EmployeeDAO();
		this.employeeView = new EmployeeView();
		this.employeeInput = new EmployeeInput();
	}
	
	public void start() throws Exception {
		
		boolean check = true;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = null;
		
		while(check) {
			
			System.out.println("1. 사원 정보 리스트");
			System.out.println("2. 개별 사원 정보");
			System.out.println("3. Last Name으로 사원 검색");
			System.out.println("4. 사원 추가");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 사원 수정");
			System.out.println("7. 프로그램 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("찾으려는 사원 번호를 입력하세요.");
				select = sc.nextInt();
				employeeDTO = employeeDAO.getDetail(select);
				if (employeeDTO != null) {
					employeeView.view(employeeDTO);
				} else {
					employeeView.view("존재하지 않는 사원입니다.");
				}
				break;
			case 3:
				System.out.println("찾으려는 사원의 Last Name을 입력하세요.");
				String search = sc.next();
				ar = employeeDAO.getFind(search);
				if (ar != null) {
					employeeView.view(ar);
				} else {
					employeeView.view("존재하지 않는 사원입니다.");
				}
				break;
			case 4:
				employeeDTO = employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if (select>0) {
					employeeView.view("추가 성공");
				} else {
					employeeView.view("추가 실패");
				}
				break;
			case 5:
				employeeDTO = employeeInput.deleteData();
				select = employeeDAO.deleteData(employeeDTO);
				if (select>0) {
					employeeView.view("삭제 성공");
				} else {
					employeeView.view("삭제 실패");
				}
				break;
			case 6:
				employeeDTO = employeeInput.updateData();
				select = employeeDAO.updateData(employeeDTO);
				if (select>0) {
					employeeView.view("수정 성공");
				} else {
					employeeView.view("수정 실패");
				}
				break;
			case 7:
				System.out.println("프로그램이 종료됩니다.");
				check = false;
				break;
			default:
				System.out.println("오류입니다. 다시 선택해 주세요.");
			}
			
		}
		
	}
	
}
