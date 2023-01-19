package com.mhj.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mhj.main.util.DBConnection;

public class EmployeeDAO {
	
	//전체 정보
	public ArrayList<EmployeeDTO> getList() throws Exception {
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		//1-2.
		Connection connection = DBConnection.getConncetion();
		
		//3. Query문 작성
		String sql = "SELECT * FROM EMPLOYEES ORDER BY HIRE_DATE ASC";
		
		//4. Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(employeeDTO);
			
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
		
	}
	
	//세부 정보
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		
		EmployeeDTO employeeDTO = null;
		
		//1-2.
		Connection connection = DBConnection.getConncetion();
		
		//3. Query문 작성
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		//4. Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 세팅
		st.setInt(1, employee_id);
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
		
	}
	
	//Last Name으로 검색
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		Connection connection = DBConnection.getConncetion();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, search);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(employeeDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}

	//Insert
	public int setData(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEmail());
		st.setString(4, employeeDTO.getPhone_number());
		st.setDate(5, employeeDTO.getHire_date());
		st.setString(6, employeeDTO.getJob_id());
		st.setDouble(7, employeeDTO.getSalary());
		st.setDouble(8, employeeDTO.getCommission_pct());
		st.setInt(9, employeeDTO.getManager_id());
		st.setInt(10, employeeDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	//delete
	public int deleteData(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	//update
	public int updateData(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConncetion();
		
		String sql = "UPDATE EMPLOYEES SET EMAIL=?, SALARY=? "
				+ "WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getEmail());
		st.setDouble(2, employeeDTO.getSalary());
		st.setInt(3, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
}
