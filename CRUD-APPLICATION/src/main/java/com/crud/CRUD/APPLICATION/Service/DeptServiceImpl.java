package com.crud.CRUD.APPLICATION.Service;

import com.crud.CRUD.APPLICATION.Entity.Department;
import com.crud.CRUD.APPLICATION.Repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptRepository deptRepository;

    @Override
    public Department saveDepartment(Department department) {
        Department savedDepartment = deptRepository.save(department);
        return savedDepartment;
    }
    @Override
    public List<Department> findByDCodeAndName(String dCode, String dName) {
        return deptRepository.findByDCodeAndName(dCode, dName);
    }

    @Override
    public List readAll() {
        return (List<Department>) deptRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        deptRepository.deleteById(id);
    }

    @Override
    public Optional<Department> readById(Long id) {
        return deptRepository.findById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department d= deptRepository.findById(id).get();
        d.setDepartmentName(department.getDepartmentName());
        d.setDepartmentAddress(department.getDepartmentAddress());
        d.setDepartmentCode(department.getDepartmentCode());

        return deptRepository.save(d);
    }
}
