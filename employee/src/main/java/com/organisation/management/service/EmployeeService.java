package com.organisation.management.service;

import com.organisation.management.dto.CreateEmployeeRequest;
import com.organisation.management.dto.EmployeeDto;
import com.organisation.management.entity.CompanyEntity;
import com.organisation.management.entity.EmployeeEntity;
import com.organisation.management.repository.CompanyRepository;
import com.organisation.management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public void createEmployee(CreateEmployeeRequest request) {
        CompanyEntity companyEntity = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Cég nem található ezzel az ID-val: " + request.getCompanyId()));
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(request.getName());
        employeeEntity.setEmail(request.getEmail());
        employeeEntity.setSalary(request.getSalary());
        employeeEntity.setCompany(companyEntity);

        employeeRepository.save(employeeEntity);
    }

    public List<EmployeeDto> getEmployeesByCompany(Long companyId) {
        return employeeRepository.findAllByCompany_Id(companyId)
                .stream()
                .map(emp -> new EmployeeDto(emp.getId(), emp.getName(),
                        emp.getEmail(), emp.getSalary(), emp.getCompany().getId()))
                .toList();
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with this ID doesen't exist: " + id);
        }
        employeeRepository.deleteById(id);
    }
}


