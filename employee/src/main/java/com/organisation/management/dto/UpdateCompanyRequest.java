package com.organisation.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateCompanyRequest {


    @NotBlank(message = "A név nem lehet üres!")
    @Size(min = 2, max = 255)
    private String name;


    @NotBlank(message = "A tevékenységi kör nem lehet üres!")
    @Size(max = 255)
    private String scopeOfActivities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScopeOfActivities() {
        return scopeOfActivities;
    }

    public void setScopeOfActivities(String scopeOfActivities) {
        this.scopeOfActivities = scopeOfActivities;
    }
}
