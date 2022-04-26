package com.luv2code.springboot.thymleafdemo.dao;


import com.luv2code.springboot.thymleafdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * for Query Details
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
     * @return
     */
    public List<Employee> findAllByOrderByLastNameAsc();
}
