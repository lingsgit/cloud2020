package com.lzw.springboot.mapper;

import com.lzw.springboot.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public  Department getDepById(Integer id);
    @Select("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int saveDept(Department depart);

    @Insert("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department depart);
}
