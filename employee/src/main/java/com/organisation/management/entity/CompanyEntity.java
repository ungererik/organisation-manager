package com.organisation.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @Column(name = "scope_of_activities", nullable = false)
    private String scopeOfActivities;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;
}
