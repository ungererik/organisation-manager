package com.organisation.management.controller;


import com.organisation.management.dto.CompanyDto;
import com.organisation.management.dto.CreateCompanyRequest;
import com.organisation.management.dto.UpdateCompanyRequest;
import com.organisation.management.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCompany(@Valid @RequestBody CreateCompanyRequest request) {
        companyService.createCompany(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable Long id,
                                              @Valid @RequestBody UpdateCompanyRequest request) {
        companyService.updateCompany(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
