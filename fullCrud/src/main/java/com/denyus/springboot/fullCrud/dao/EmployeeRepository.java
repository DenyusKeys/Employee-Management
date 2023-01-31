package com.denyus.springboot.fullCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.denyus.springboot.fullCrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
