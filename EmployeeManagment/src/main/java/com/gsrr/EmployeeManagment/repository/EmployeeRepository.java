package com.gsrr.EmployeeManagment.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsrr.EmployeeManagment.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    List<Employee> findTop3ByOrderBySalaryDesc();

}
