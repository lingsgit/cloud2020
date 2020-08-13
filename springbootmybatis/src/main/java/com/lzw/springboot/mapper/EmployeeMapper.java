package com.lzw.springboot.mapper;

import com.lzw.springboot.bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
