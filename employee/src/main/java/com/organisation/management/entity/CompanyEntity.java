package com.organisation.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
