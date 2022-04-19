package com.tiko.springboot.springboot.service;

import com.tiko.springboot.springboot.dto.EmployeeFullDto;
import com.tiko.springboot.springboot.model.Employee;
import com.tiko.springboot.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class EmployeeService {

    //    @Autowired
//    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getById(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        }
        return employee;

    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmp(EmployeeFullDto dto, int id) {
        Employee emp = getById(id);
        emp.setFirstname(dto.getFirstname());
        emp.setLastname(dto.getLastname());
        emp.setAge(dto.getAge());
        employeeRepository.save(emp);
    }

    public List<Employee> findByAge(int age) {
        List<Employee> employees = employeeRepository.findAllByAge(age);
        return employees;
    }

    public List<Employee> findEmployeesByName(String name) {
        List<Employee> employees = employeeRepository.findAllByFirstname(name);
        return employees;
    }

}
