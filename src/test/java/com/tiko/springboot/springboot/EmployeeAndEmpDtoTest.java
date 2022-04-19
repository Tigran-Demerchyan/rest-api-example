package com.tiko.springboot.springboot;


import com.tiko.springboot.springboot.dto.EmployeeFullDto;
import com.tiko.springboot.springboot.mapper.EmployeeEmpDtoMapper;
import com.tiko.springboot.springboot.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class EmployeeAndEmpDtoTest {
    EmployeeEmpDtoMapper mapper = Mappers.getMapper(EmployeeEmpDtoMapper.class);

    @Test
    void employeeToDto() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("Tigran");
        employee.setLastname("Demerchyan");
        employee.setAge(33);

        EmployeeFullDto employeeFullDto = mapper.employeeToDto(employee);

        Assertions.assertEquals(employee.getId(), employeeFullDto.getId());
        Assertions.assertEquals(employee.getFirstname(), employeeFullDto.getFirstname());
        Assertions.assertEquals(employee.getLastname(), employeeFullDto.getLastname());
        Assertions.assertEquals(employee.getAge(), employeeFullDto.getAge());
    }

    @Test
    void dtoToEmployee() {
        EmployeeFullDto dto = new EmployeeFullDto();
        dto.setId(2);
        dto.setFirstname("Vahe");
        dto.setLastname("Harutyunyan");
        dto.setAge(32);

        Employee employee = mapper.dtoToEmployee(dto);

        Assertions.assertEquals(dto.getId(), employee.getId());
        Assertions.assertEquals(dto.getFirstname(), employee.getFirstname());
        Assertions.assertEquals(dto.getLastname(), employee.getLastname());
        Assertions.assertEquals(dto.getAge(), employee.getAge());
    }

}
