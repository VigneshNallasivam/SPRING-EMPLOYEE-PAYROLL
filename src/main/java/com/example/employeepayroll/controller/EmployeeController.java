package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.dto.ResponseDto;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class EmployeeController
{
    @Autowired
    EmployeeService service;
    @GetMapping("/show/{name}")
    public String show(@PathVariable String name)
    {
        return "<h1>WELCOME : "+"<font color=violet>"+name+"</font>"+"</h1>";
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> insert(@Valid @RequestBody EmployeeDto employeeDto)
    {
        Employee response = service.insert(employeeDto);
        ResponseDto responseDto = new ResponseDto("Data inserted Successfully!!",response);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED );
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody EmployeeDto employeeDto,@PathVariable int id)
    {
        Employee model = service.update(employeeDto,id);
        ResponseDto responseDto = new ResponseDto("Data found Using ID for Updation",model);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAll()
    {
        List<Employee> modelList = service.findAll();
        ResponseDto responseDto = new ResponseDto("Fetched all Details!!",modelList);
        return new ResponseEntity<>(responseDto,HttpStatus.FOUND);
    }
    @GetMapping("/getting/{id}")
    public ResponseEntity<ResponseDto> getByID(@PathVariable int id)
    {
        Employee model = service.getById(id);
        ResponseDto responseDto = new ResponseDto("Data has been found!!",model);
        return new ResponseEntity<>(responseDto,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id)
    {
        service.deleteByID(id);
        ResponseDto responseDto = new ResponseDto("Data is Deleted","Successfully!!");
        return new ResponseEntity<>(responseDto,HttpStatus.OK );
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<ResponseDto> getNames(@PathVariable String name)
    {
        List<Employee> models = service.getNames(name);
        ResponseDto responseDto = new ResponseDto("All Names are Getten!",models);
        return new ResponseEntity<>(responseDto,HttpStatus.FOUND);
    }
    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<ResponseDto> getDepartment(@PathVariable String department)
    {
        List<Employee> models = service.getByDepartment(department);
        ResponseDto responseDto = new ResponseDto("All Names are Getten!",models);
        return new ResponseEntity<>(responseDto,HttpStatus.FOUND);
    }
}

