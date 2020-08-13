package com.lzw.springboot.controller;

import com.lzw.springboot.dao.DepartmentDao;
import com.lzw.springboot.dao.EmployeeDao;
import com.lzw.springboot.entities.Department;
import com.lzw.springboot.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /*查询所有*/
    @GetMapping("/emps")
    public String findAllEmp(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emps/list";
    }
    /*去添加页面*/
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emps/add";
    }
    /*添加*/
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee/emps";
    }
    /*修改*/
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee/emps";
    }
    /*去修改页面*/
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "emps/add";
    }

    /*删除*/
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee/emps";
    }
}
