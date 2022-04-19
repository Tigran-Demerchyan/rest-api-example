package com.tiko.springboot.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFullDto {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
}
