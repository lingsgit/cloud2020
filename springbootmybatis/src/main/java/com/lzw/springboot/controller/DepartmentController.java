package com.lzw.springboot.controller;

import com.lzw.springboot.bean.Department;
import com.lzw.springboot.bean.Employee;
import com.lzw.springboot.mapper.DepartmentMapper;
import com.lzw.springboot.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDepById(id);
    }

    @GetMapping("/dept")
    public Department addDept(Department department){
       departmentMapper.saveDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee addDept(Employee employee){
        employeeMapper.insertEmp(employee);
        return employee;
    }
}
