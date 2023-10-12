package com.crud.CRUD.APPLICATION.Controller;

import com.crud.CRUD.APPLICATION.Entity.Department;
import com.crud.CRUD.APPLICATION.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;
//  I don't have any methods in my department file, that I'm talking to directly,
//  but I want some methods from the DeptService file
//  So in that case im auto wiring the instance
    @PostMapping("api/departments/department")
//    create a record department in db
    public ResponseEntity saveDepartment(@RequestBody Department department){ // method
//        www.google.com/yeswanth/history/4.10.2 => url(best practice)
        Department savedDepartment = deptService.saveDepartment(department);
        return new ResponseEntity(savedDepartment, HttpStatus.CREATED);
    }
//    Readoperation
    @GetMapping("api/departments/departments")
    public ResponseEntity<List> readDepartment(){
        return new ResponseEntity<>(deptService.readAll(), HttpStatus.OK);
    }
    @DeleteMapping("api/departments/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id){
        deptService.deleteById(id);
        return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("api/departments/department/{id}")
    public ResponseEntity readById(@PathVariable Long id){
        return new ResponseEntity(deptService.readById(id),HttpStatus.OK);
    }
    @PutMapping("api/departments/department/{id}")
    public ResponseEntity updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity(deptService.updateDepartment(id,department),HttpStatus.OK);
    }

    @GetMapping("api/departments/department/{dCode}/{dName}")
    public ResponseEntity findByCodeAndName(@PathVariable("dCode") String dCode, @PathVariable("dName") String dName){
        return new ResponseEntity(deptService.findByDCodeAndName(dCode, dName), HttpStatus.OK);
    }

}
