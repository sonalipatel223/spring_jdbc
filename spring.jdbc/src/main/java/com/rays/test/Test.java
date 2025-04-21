package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.dto.EmployeeDTO;
import com.rays.service.EmployeeServiceInt;

public class Test {

	private EmployeeServiceInt service = null;

	public void setService(EmployeeServiceInt service) {
		this.service = service;
	}

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Shivanshi.xml");
		Test test = (Test) context.getBean("test");

		test.testAdd();

	}

	public void testAdd() {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(1);
		dto.setFirstName("xyz");
		dto.setLastName("xyz");
		dto.setLogin("admin");
		dto.setPassword("pass1234");
		long pk = service.add(dto);
		System.out.println("Data Inserted... pk = " + pk);
	}

}
