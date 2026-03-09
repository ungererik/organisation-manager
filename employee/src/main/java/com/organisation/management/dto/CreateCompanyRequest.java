package com.organisation.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCompanyRequest {

    @NotBlank(message = "A cég neve nem lehet üres!")
    @Size(min = 2, max = 255, message = "A névnek 2 és 255 karakter között kell lennie!")
    private String name;

    @Size(min = 2, max = 255, message = "A tevékenységi kör nem lehet üres!")
    @NotBlank(message = "A tevékenységi kör nem lehet üres!")
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
