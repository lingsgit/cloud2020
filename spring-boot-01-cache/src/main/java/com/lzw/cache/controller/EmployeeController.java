package com.lzw.cache.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lzw.cache.bean.Employee;
import com.lzw.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return  employeeService.updateEmp(employee);
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
}
