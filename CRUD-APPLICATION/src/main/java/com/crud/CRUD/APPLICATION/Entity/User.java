package com.crud.CRUD.APPLICATION.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private boolean enabled;
    private String roles;
}
