package com.crud.CRUD.APPLICATION.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // no need to add the getter and setter
@NoArgsConstructor // no need to add the empty constructor
@AllArgsConstructor // no need to add the all values constructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
