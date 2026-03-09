package com.organisation.management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {

    private String name;
    private String email;
    private Double salary;
    private Long companyId;
}
