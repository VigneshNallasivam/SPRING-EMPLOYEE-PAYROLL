package com.example.employeepayroll.repository;

import com.example.employeepayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    @Query(value = "select * from employee.empTable where empTable.name=:name",nativeQuery = true)
    List<Employee> findByName(String name);

    @Query(value = "select * from employee.empTable where empTable.name=:department",nativeQuery = true)
    List<Employee> findByDepartment(String department);
}
