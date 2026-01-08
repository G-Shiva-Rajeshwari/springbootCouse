package com.gsrr.EmployeeManagment.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.EmployeeManagment.entity.Employee;
import com.gsrr.EmployeeManagment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
    private EmployeeService service;

//	
	@PostMapping("/add")
	//public void addEmployee(@RequestParam Integer id,@RequestParam String name,@RequestParam Double salary,@RequestParam String department) {
	public void addEmployee(@RequestBody Employee person) {
	//Employee person = new Employee(id,name, salary, department);
		service.addEmployee(person);
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(
	        @PathVariable Integer id,
	        @RequestBody Employee employeeDetails) {

	    service.updateEmployee(id, employeeDetails);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		service.deleteEmployeeById(id);
	}
	
	@GetMapping("/getById/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/getTop3")
	public List<Employee> getTop3BySalary(){
		return service.getTop3BySalary();
	}
}
