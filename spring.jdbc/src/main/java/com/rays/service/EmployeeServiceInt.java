package com.rays.service;

import java.util.List;

import com.rays.dto.EmployeeDTO;

public interface EmployeeServiceInt {
	
	public long add(EmployeeDTO dto);
	public void update(EmployeeDTO dto);
	public void delete(long id);
	public EmployeeDTO findByLogin(String login);
	public EmployeeDTO findByPK(long pk);
	public EmployeeDTO authenticate(String login,String password);
	public List search(EmployeeDTO dto);
	public List search(EmployeeDTO dto,int pageNo,int pageSize);
	

}
