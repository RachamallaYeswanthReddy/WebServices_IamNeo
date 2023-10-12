package com.crud.CRUD.APPLICATION.Repository;

import com.crud.CRUD.APPLICATION.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {

    List<Department> findByDepartmentCodeAndDepartmentName(String departmentCode, String departmentName);


    Department findByDepartmentName(String dName);

    Department findByDepartmentAddress(String address);

    // clauses
//    custome queery with @Query +JPQL

    @Query(value = "select e from Department e ORDER BY departmentName")
    public List<Department> findAllOrderByName();
//    JPQl => select e from Department e ORDER BY departmentName
//    SQl => select * from Department ORDER BY department_name

//    Indexed Query parameter
    @Query(value = "select e from Department e WHERE departmentCode=?1")
    public List<Department> findByDCode(String departmentCode);

    @Query(value = "SELECT e FROM Department e WHERE departmentCode = ?1 AND departmentName = ?2")
    public List<Department> findByDCodeAndName(String dName ,String dCode);

//    select * from departments where department_name = "Maths";
    @Query(value = "SELECT e FROM Department e WHERE departmentCode = :dCode")
    public List<Department> findByDCode1(@Param("dCode") String dCode);

    @Query(value = "SELECT e FROM Department e WHERE departmentCode = :dCode AND departmentName =:dName")
    public List<Department> findByDCodeAndName1(@Param("dCode") String dName ,@Param("dName") String dCode);

    //Custom query with @Query+Native Query
    @Query(value = "SELECT * FROM Department WHERE departmentCode = :dCode ORDER BY department_name",nativeQuery = true)
    public List<Department> findByDCodeNative(@Param("dCode") String dCode);

    // Indexed parameters
    @Query(value = "SELECT * FROM Department WHERE departmentCode = ?1 ORDER BY department_name",nativeQuery = true)
    public List<Department> findByDCodeNative1(String dCode);

}

//Entity == Table
//Department == Department
//maths(instace of Department) == record in table(1,maths, block)
