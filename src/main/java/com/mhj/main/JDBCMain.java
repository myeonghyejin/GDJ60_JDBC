package com.mhj.main;

import com.mhj.main.departments.DepartmentController;
import com.mhj.main.departments.DepartmentDAO;
import com.mhj.main.departments.DepartmentDTO;
import com.mhj.main.employees.EmployeeController;
import com.mhj.main.locations.LocationController;
import com.mhj.main.locations.LocationDAO;
import com.mhj.main.locations.LocationDTO;
import com.mhj.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {

		System.out.println("Strat");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();	
		LocationDAO locationDAO = new LocationDAO();
		
		DepartmentController departmentController = new DepartmentController();
		LocationController locationController = new LocationController();
		EmployeeController employeeController = new EmployeeController();
		
		try {
//			departmentDAO.getList();
//			locationDAO.getList();
//			departmentDAO.getDetail(3000);
//			locationDAO.getDetail(1000);
			
//			departmentController.start();
			locationController.start();
//			employeeController.start();
			
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(280);
//			int result = departmentDAO.deleteData(departmentDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finish");

	}

}