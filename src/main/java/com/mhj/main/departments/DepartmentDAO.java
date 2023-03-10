package com.mhj.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.mhj.main.employees.EmployeeDTO;
import com.mhj.main.util.DBConnection;

public class DepartmentDAO {
	
	public void getInfos() throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN DEPARTMENTS D "
				+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "WHERE D.DEPARTMENT_ID = 30";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeeDTO(new ArrayList<EmployeeDTO>());
		
		while (rs.next()) {
			if(departmentDTO.getDepartment_name() == null) {
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTO().add(employeeDTO);
		}
	}
	
	//join
	public DepartmentDTO getInfo() throws Exception {
		DepartmentDTO departmentDTO = null;
		
		Connection connection = DBConnection.getConncetion();
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D "
				+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE E.EMPLOYEE_ID = 100";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeeDTO(new ArrayList<EmployeeDTO>());
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.getEmployeeDTO().get(0).setFirst_name(rs.getString("FIRST_NAME"));
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTO().add(employeeDTO);
		}
		
		return departmentDTO;
	}
	
	//????????? ??????
	public HashMap<String, Double> getAvg() throws Exception {
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Connection connection = DBConnection.getConncetion();
		
		String sql = "SELECT AVG(SALARY), SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//1. List, Array
		//2. DTO (Class)
		//3. Map (Key, Value)
		
		map.put("avg", rs.getDouble("AVG(SALARY)"));
		map.put("sum", rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, connection);
		
		return map;
	}
	
	//method 1 : query 1
	
	//update
	public int updateData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	//insert
	public int setData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	public DepartmentDTO getDetail(int departments_id) throws Exception {
		
		DepartmentDTO departmentDTO = null;
		
		Connection connection = DBConnection.getConncetion();
		//3
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		//4
		PreparedStatement st = connection.prepareStatement(sql);
		//5
		st.setInt(1, departments_id);
		//6
		ResultSet rs = st.executeQuery();
		if (rs.next()) {			
			departmentDTO = new DepartmentDTO();
			
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));		
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));	
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));	
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));	
		}
		//7
		DBConnection.disConnect(rs, st, connection);
		
		return departmentDTO;
	}
	
	public ArrayList<DepartmentDTO> getList() throws Exception {
		
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		//DBConnection dbConnection = new DBConnection();
		Connection connection = DBConnection.getConncetion();
		
		//1. ?????? ?????? ??????
		
		//2. DB ??????
		
		//3. Query??? ??????
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//4. Query??? ?????? ??????
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? ??????
		
		//6. ?????? ?????? ??? ?????? ??????
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));		
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));	
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));	
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));	
			ar.add(departmentDTO);
		}
		
		//7. ?????? ??????
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}

}