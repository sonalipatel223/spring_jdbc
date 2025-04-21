package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.EmployeeDTO;

public class EmployeeMapper implements RowMapper<EmployeeDTO>{

	public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setId(rs.getLong(1));
		emp.setFirstName(rs.getString(2));
		emp.setLastName(rs.getString(3));
		emp.setLogin(rs.getString(4));
		emp.setPassword(rs.getString(5));
		
		
		return emp;
	}

}
