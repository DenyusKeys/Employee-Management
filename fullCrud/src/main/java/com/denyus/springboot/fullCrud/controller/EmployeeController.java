package com.denyus.springboot.fullCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denyus.springboot.fullCrud.entity.Employee;
import com.denyus.springboot.fullCrud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/list") 
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add data to the model v refers to ${employees} in html file
		theModel.addAttribute("employees", theEmployees);
		
		// reference html to display data
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd") 
	public String showFormForAdd(Model theModel) {
			
		// get employee from service
		Employee theEmployee = new Employee();
		
		// Add data to model.  No data currently so will be blank.
		theModel.addAttribute("employee", theEmployee);
			
		return "employees/employee-form";
		}
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get employee from service
		Employee theEmployee = employeeService.findById(theId);
		
		// place employee in model to populate form
		theModel.addAttribute("employee", theEmployee);
		
		// open the form with populated data
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		return"redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		return"redirect:/employees/list";
	}


}
