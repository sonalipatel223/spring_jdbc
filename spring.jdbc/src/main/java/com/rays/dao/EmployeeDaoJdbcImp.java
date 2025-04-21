package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rays.dto.EmployeeDTO;

public class EmployeeDaoJdbcImp implements EmployeeDaoInt {

	private JdbcTemplate jdbcTemplete;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplete = new JdbcTemplate(dataSource);
	}

	public long add(EmployeeDTO dto) {

		String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
		int pk = jdbcTemplete.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());

		return pk;
	}

	public void update(EmployeeDTO dto) {

		String sql = "UPDATE EMPLOYEE SET FIRST_NAME=?, LAST_NAME=? , PASSWORD=? ,WHERE ID=?";
		int i = jdbcTemplete.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

	}

	public void delete(long id) {

		String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
		Object[] params = { id };
		int i = jdbcTemplete.update(sql, params);

	}

	public EmployeeDTO findByLogin(String login) {

		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM EMPLOYEE WHERE LOGIN=?";
		Object[] params = { login };
		EmployeeDTO emp = jdbcTemplete.queryForObject(sql, params, new EmployeeMapper());

		return emp;
	}

	public EmployeeDTO findByPK(long pk) {

		String sql = "SELECT ID,FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM EMPLOYEE WHERE ID=?";
		Object[] params = { pk };
		List list = jdbcTemplete.query(sql, params, new EmployeeMapper());

		EmployeeDTO dto = null;
		if (list.size() > 0) {
			dto = (EmployeeDTO) list.get(0);
		}

		return null;
	}

	public EmployeeDTO authenticate(String login, String password) {
		try {

			String sql = "SELECT ID,FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE LOGIN=? AND PASSWORD=?";
			Object[] params = { login, password };
			EmployeeDTO emp = jdbcTemplete.queryForObject(sql, params, new EmployeeMapper());
			return emp;
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	public List search(EmployeeDTO dto) {

		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD FROM EMPLOYEE";
		List list = jdbcTemplete.query(sql, new EmployeeMapper());

		return list;
	}

	public List search(EmployeeDTO dto, int pageNo, int pageSize) {

		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD FROM EMPLOYEE LIMIT" + pageNo + "," + pageSize;
		List list = jdbcTemplete.query(sql, new EmployeeMapper());

		return list;
	}

}
