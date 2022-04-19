package com.tiko.springboot.springboot.repository;

import com.tiko.springboot.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByFirstname(String name);
    public List<Employee> findAllByAge(int age);
}
