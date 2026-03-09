package com.organisation.management.service;

import com.organisation.management.dto.CompanyDto;
import com.organisation.management.dto.CreateCompanyRequest;
import com.organisation.management.dto.UpdateCompanyRequest;
import com.organisation.management.entity.CompanyEntity;
import com.organisation.management.mapper.CompanyMapper;
import com.organisation.management.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public void createCompany(CreateCompanyRequest request) {
        CompanyEntity entity = companyMapper.mapToEntity(request);
        companyRepository.save(entity);
    }

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::mapToDto)
                .toList();
    }

    @Transactional
    public void updateCompany(Long id, UpdateCompanyRequest request) {
        CompanyEntity company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cég nem található ezzel az ID-val: " + id));
        company.setName(request.getName());
        company.setScopeOfActivities(request.getScopeOfActivities());

        companyRepository.save(company);

    }

    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company with this ID doesen't exist: " + id);
        }
        companyRepository.deleteById(id);
    }
}
