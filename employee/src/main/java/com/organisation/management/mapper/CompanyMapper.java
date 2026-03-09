package com.organisation.management.mapper;

import com.organisation.management.dto.CompanyDto;
import com.organisation.management.dto.CreateCompanyRequest;
import com.organisation.management.entity.CompanyEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyEntity mapToEntity(CreateCompanyRequest request) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(request.getName());
        entity.setScopeOfActivities(request.getScopeOfActivities());

        return entity;
    }

    public CompanyDto mapToDto(CompanyEntity entity) {
        return new CompanyDto(
                entity.getName(),
                entity.getScopeOfActivities());
    }
}
