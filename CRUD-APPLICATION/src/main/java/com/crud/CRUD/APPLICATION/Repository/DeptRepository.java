package com.crud.CRUD.APPLICATION.Repository;

import com.crud.CRUD.APPLICATION.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {

    static Department saveDepartment(Department department) {
        return null;
    }
}
