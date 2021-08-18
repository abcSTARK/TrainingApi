package com.training.api.TrainingApi.controller;

import com.training.api.TrainingApi.pojo.Employee;
import com.training.api.TrainingApi.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/messages")
    public String message(){
        return "Welcome to boot";
    }

    @Autowired
    EmployeeDAO dao;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        //return Arrays.asList(new Employee(),new Employee("name","adress",1,20));
        return dao.findAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        if(dao.addEmployee(employee)>0){
            return employee;
        }
        return new Employee();
    }

}
