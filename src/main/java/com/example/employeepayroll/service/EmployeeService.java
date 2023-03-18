package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.exception.EmployeeException;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService
{
    @Autowired
    EmployeeRepository repo;
    @Override
    public Employee insert(EmployeeDto employeeDto)
    {
        Employee empModel = new Employee(employeeDto);
        repo.save(empModel);
        return empModel;
    }
    @Override
    public Employee getById(int id)
    {
        Employee model = repo.findById(id).get();
        if(repo.findById(id).isPresent())
        {
            return model;
        }
        else
        {
            throw new EmployeeException("Id Not Found!!");
        }
    }
    @Override
    public Employee update(EmployeeDto employeeDto, int id)
    {
        Employee model = repo.findById(id).get();
        if(repo.findById(id).isPresent())
        {
            model.setName(employeeDto.getName());
            model.setPic(employeeDto.getPic());
            model.setGender(employeeDto.getGender());
            model.setNotes(employeeDto.getNotes());
            model.setSalary(employeeDto.getSalary());
            model.setStartDate(employeeDto.getStartDate());
            model.setDepartment(employeeDto.getDepartment());
            repo.save(model);
            return model;
        }
        else
        {
            throw new EmployeeException("Id Not Found!!");
        }
    }
    @Override
    public String deleteByID(int id)
    {
        if(repo.existsById(id))
        {
            repo.deleteById(id);
            return "Deleted";
        }
        else {
            throw new EmployeeException("ID IS NOT-FOUND..!!(TO BE DELETED)");
        }
    }
    @Override
    public List<Employee> findAll()
    {
        List<Employee> list = repo.findAll();
        if(repo.findAll().isEmpty())
        {
            throw new EmployeeException("OOPS..! Empty DATA-BASE...");
        }
        else {
            return list;
        }
    }
    @Override
    public List<Employee> getNames(String name)
    {
        List<Employee>  models = repo.findByName(name);
        if(repo.findByName(name).isEmpty())
        {
            throw new EmployeeException("Name Not Found!!");
        }
        else {
            return models;
        }
    }

    @Override
    public List<Employee> getByDepartment(String department)
    {
        List<Employee>  models = repo.findByDepartment(department);
        if(repo.findByDepartment(department).isEmpty())
        {
            throw new EmployeeException("Department Not Found!!");
        }
        else {
            return models;
        }

    }
}
