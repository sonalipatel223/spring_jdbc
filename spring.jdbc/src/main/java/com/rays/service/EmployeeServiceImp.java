package com.rays.service;

import java.util.List;

import com.rays.dao.EmployeeDaoInt;
import com.rays.dto.EmployeeDTO;

public class EmployeeServiceImp implements EmployeeServiceInt {

	private EmployeeDaoInt dao = null;

	public void setDao(EmployeeDaoInt dao) {
		this.dao = dao;
	}

	public long add(EmployeeDTO dto) {

		long pk = dao.add(dto);

		return pk;
	}

	public void update(EmployeeDTO dto) {

		dao.update(dto);

	}

	public void delete(long id) {

		dao.delete(id);

	}

	public EmployeeDTO findByLogin(String login) {

		return dao.findByLogin(login);
	}

	public EmployeeDTO findByPK(long pk) {

		return dao.findByPK(pk);
	}

	public EmployeeDTO authenticate(String login, String password) {

		EmployeeDTO emp = dao.authenticate(login, password);
		return emp;
	}

	public List search(EmployeeDTO dto) {

		return dao.search(dto);
	}

	public List search(EmployeeDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}

}
