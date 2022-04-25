package com.luv2code.springboot.thymleafdemo.dao;


import com.luv2code.springboot.thymleafdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
