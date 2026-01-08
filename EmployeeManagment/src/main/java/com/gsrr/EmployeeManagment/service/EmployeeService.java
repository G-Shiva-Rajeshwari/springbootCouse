package com.gsrr.EmployeeManagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.gsrr.EmployeeManagment.entity.Employee;
import com.gsrr.EmployeeManagment.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public void addEmployee(Employee person) {
	    repository.save(person);
	}
	
	public Employee updateEmployee(Integer id, Employee updatedEmployee) {

	    Employee existingEmployee = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    // Set updated values
	    existingEmployee.setName(updatedEmployee.getName());
	    existingEmployee.setSalary(updatedEmployee.getSalary());
	    existingEmployee.setDepartment(updatedEmployee.getDepartment());
	    // add other fields…

	    return repository.save(existingEmployee);
	}
	
	public void deleteEmployeeById(Integer id) {
		repository.deleteById(id);
	}
	
	public Employee getEmployeeById(Integer id) {
	return repository.findById(id).orElse(new Employee(0,"null",0.0,"null"));
	}
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	public List<Employee> getTop3BySalary(){
		return repository.findTop3ByOrderBySalaryDesc();
		
		//no pageable required
		// return repository.findTop3ByOrderBySalaryDesc();
	}
	
}
