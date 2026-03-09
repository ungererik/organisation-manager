package com.organisation.management.controller;

import com.organisation.management.dto.CreateEmployeeRequest;
import com.organisation.management.dto.EmployeeDto;
import com.organisation.management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody CreateEmployeeRequest request){
        employeeService.createEmployee(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{companyId}")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByCompany(@PathVariable Long companyId){
        List<EmployeeDto> employees = employeeService.getEmployeesByCompany(companyId);
        return ResponseEntity.ok(employees);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update-salary/{id}")
    public ResponseEntity<Void> updateSalary(@PathVariable Long id, @RequestBody Double newSalary) {
        employeeService.updateEmployeeSalary(id,newSalary);
        return ResponseEntity.ok().build();
    }

}
