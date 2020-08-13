package com.lzw.cache.service;

import com.lzw.cache.bean.Employee;
import com.lzw.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public void insertEmp(Employee employee){
        employeeMapper.insertEmp(employee);
    }
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmp(id);
    }
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }
    @Cacheable(cacheNames = "emp")
    public Employee getEmpById(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

}
