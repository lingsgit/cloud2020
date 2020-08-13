package com.lzw.cache.mapper;

import com.lzw.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {
    @Insert("INSERT INTO employee (lastName, email, gender, d_id) VALUES (#{lastName}, #{email}, #{gender}, #{dId})")
    public void insertEmp(Employee employee);
    @Delete("delete from employee where id=#{id}")
    public void deleteEmp(Integer id);
    @Update("UPDATE employee SET lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);
    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);
}
