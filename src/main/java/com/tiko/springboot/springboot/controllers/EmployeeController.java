package com.tiko.springboot.springboot.controllers;

import com.tiko.springboot.springboot.dto.EmployeeFullDto;
import com.tiko.springboot.springboot.mapper.EmployeeEmpDtoMapper;
import com.tiko.springboot.springboot.model.Employee;
import com.tiko.springboot.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeEmpDtoMapper mapper;

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeFullDto> showAll() {
        List<Employee> allEmployees = service.getAll();
        return allEmployees.stream()
                .map(e -> mapper.employeeToDto(e))
                .collect(Collectors.toList());


    }

    @PostMapping
    public void createEmployee(@RequestBody EmployeeFullDto dto) {
        Employee employee = mapper.dtoToEmployee(dto);
        service.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeFullDto getEmpById(@PathVariable int id) {
        Employee employee = service.getById(id);
        return mapper.employeeToDto(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody EmployeeFullDto dto, @PathVariable int id) {

        service.updateEmp(dto, id);
    }

    @GetMapping("/byAge/{age}")
    public List<Employee> showEmpByAge(@PathVariable int age) {
        return service.findByAge(age);
    }

    @GetMapping("/byName/{name}")
    public List<Employee> showEmpByName(@PathVariable String name) {
        return service.findEmployeesByName(name);
    }
}
