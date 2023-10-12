package com.crud.CRUD.APPLICATION.Service;

import com.crud.CRUD.APPLICATION.Entity.Department;

import java.util.List;
import java.util.Optional;

public interface DeptService {
    Department saveDepartment(Department department);


    List<Department> findByDCodeAndName(String dCode, String dName);

    //    Above i am declaring the Dept instead of void bcozz..
//    I need to display department instead of null
    List readAll();

    void deleteById(Long id);

    Optional<Department> readById(Long id);

    Department updateDepartment(Long id, Department department);

}
