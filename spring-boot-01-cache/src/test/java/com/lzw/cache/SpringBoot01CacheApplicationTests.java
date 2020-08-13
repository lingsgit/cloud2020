package com.lzw.cache;

import com.lzw.cache.bean.Employee;
import com.lzw.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBoot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;
    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }
    @Test
    public void test01(){
        //stringRedisTemplate.opsForValue().append("msg","world");
        String s = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(s);
    }

    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmpById(1);
        redisTemplate.opsForValue().set("emp",emp);
    }

    @Test
    public void test03(){
        Employee emp = employeeMapper.getEmpById(1);
       // empRedisTemplate.opsForValue().set("emp-01",emp);
        Employee employee = empRedisTemplate.opsForValue().get("emp-01");
        System.out.println(employee);
    }

}
