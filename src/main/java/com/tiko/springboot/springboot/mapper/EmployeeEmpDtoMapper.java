package com.tiko.springboot.springboot.mapper;

import com.tiko.springboot.springboot.dto.EmployeeFullDto;
import com.tiko.springboot.springboot.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeEmpDtoMapper {

    @Mappings({@Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "firstname", source = "dto.firstname"),
            @Mapping(target = "lastname", source = "dto.lastname"),
            @Mapping(target = "age", source = "dto.age")})
    Employee dtoToEmployee(EmployeeFullDto dto);


    @Mappings({@Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "firstname", source = "entity.firstname"),
            @Mapping(target = "lastname", source = "entity.lastname"),
            @Mapping(target = "age", source = "entity.age")})
    EmployeeFullDto employeeToDto(Employee entity);
}
