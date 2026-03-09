package com.organisation.management.controller;

import com.organisation.management.dto.CreateEmployeeRequest;
import com.organisation.management.dto.EmployeeDto;
import com.organisation.management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request){
        employeeService.createEmployee(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{companyId}")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByCompany(@PathVariable Long companyId){
        List<EmployeeDto> employees = employeeService.getEmployeesByCompany(companyId);
        return ResponseEntity.ok(employees);

    }

}
