package com.tiko.springboot.springboot.service;

import com.tiko.springboot.springboot.dto.EmployeeFullDto;
import com.tiko.springboot.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EntityManager manager;

    public List<Employee> getAll() {
        return manager.createQuery("from Employee", Employee.class).getResultList();
    }

    public void createEmployee(Employee employee) {
        manager.persist(employee);
    }

    public Employee getById(int id) {
        return manager.find(Employee.class, id);
    }

    public void deleteEmployee(int id) {
        Employee byId = getById(id);
        manager.remove(byId);
    }

    public void updateEmp(Employee byId) {
        manager.merge(byId);
    }
}
