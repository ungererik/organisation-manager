package com.organisation.management.dto;

import com.organisation.management.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private double salary;
    private Long companyId;


    public EmployeeDto mapToDto(EmployeeEntity employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getCompany().getId()
        );

    }
}

