package com.organisation.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateEmployeeRequest {

    @NotBlank(message = "The name field cannot be empty!")
    private String name;

    @Email(message = "Invalid e-mail format!")
    @NotBlank(message = "The e-mail field cannot be empty!")
    private String email;

    @Positive(message = "A salary must be a positive number!")
    @NotBlank(message = "The salary field cannot be empty!")
    private Double salary;

    @NotNull(message = "The company ID field cannot be empty!")
    private Long companyId;
}
