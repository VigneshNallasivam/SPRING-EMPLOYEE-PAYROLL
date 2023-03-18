package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="empTable")
@NoArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String pic;
    private String gender;
    private String salary;
    private String notes;
    private String startDate;
    @ElementCollection
    @CollectionTable(name = "department_table", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;
    public Employee(EmployeeDto employeeDto)
    {
        this.name = employeeDto.getName();
        this.pic = employeeDto.getPic();
        this.gender = employeeDto.getGender();
        this.salary = employeeDto.getSalary();
        this.notes = employeeDto.getNotes();
        this.startDate = employeeDto.getStartDate();
        this.department = employeeDto.getDepartment();
    }
}