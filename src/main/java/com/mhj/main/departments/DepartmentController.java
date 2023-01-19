package com.mhj.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	
	public DepartmentController() {
		this.sc = new Scanner(System.in);
		this.departmentDAO = new DepartmentDAO();
		this.departmentView = new DepartmentView();
		this.departmentInput = new DepartmentInput();
	}
	
	public void start() throws Exception {
		boolean check = true;
		DepartmentDTO departmentDTO = null;
		ArrayList<DepartmentDTO> ar = null;
		
		while(check) {
			System.out.println("1. 부서 전체 정보");
			System.out.println("2. 부서 상세 정보");
			System.out.println("3. 부서 추가");
			System.out.println("4. 부서 삭제");
			System.out.println("5. 부서 수정");
			System.out.println("6. 프로그램 종료");
			
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("부서 번호를 입력하세요.");
				select = sc.nextInt();
				departmentDTO = departmentDAO.getDetail(select);
				departmentView.view(departmentDTO);
				if (departmentDTO == null) {
					departmentView.view("없는 부서입니다.");
				}
				break;
			case 3:
				departmentDTO = departmentInput.setData();
				select = departmentDAO.setData(departmentDTO);
				if (select>0) {
					departmentView.view("추가 성공");
				} else {
					departmentView.view("추가 실패");
				}
				break;
			case 4:
				departmentDTO = departmentInput.deleteDate();
				select = departmentDAO.deleteData(departmentDTO);
				if (select>0) {
					departmentView.view("삭제 성공");
				} else {
					departmentView.view("삭제 실패");
				}
				break;
			case 5:
				departmentDTO = departmentInput.updateData();
				select = departmentDAO.updateData(departmentDTO);
				if(select>0) {
					departmentView.view("수정 성공");
				} else {
					departmentView.view("수정 실패");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("오류입니다. 다시 선택하세요.");
			}
			
		}
	}

}