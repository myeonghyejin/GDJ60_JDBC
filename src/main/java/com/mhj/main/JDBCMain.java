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
		
		FrontController fc = new FrontController();
		
		try {
			
			fc.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finish");

	}

}