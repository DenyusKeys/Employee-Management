package com.denyus.springboot.fullCrud.service;

import java.util.List;

import com.denyus.springboot.fullCrud.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
