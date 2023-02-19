package com.spring.payroll.service;
import com.spring.payroll.dto.EmployeeDto;
import com.spring.payroll.entity.Employee;
import java.util.List;
public interface IEmployeeService
{
    Employee insert(EmployeeDto employeeDto);
    Employee getById(int id);
    List<Employee> findAll();
    Employee update(EmployeeDto employeeDto, int id);
    String deleteByID(int id);
    List<Employee> getNames(String name);
}

