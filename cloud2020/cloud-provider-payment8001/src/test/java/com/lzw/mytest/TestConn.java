package com.lzw.mytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @ProjectName cloud2020
 * @ClassName TestConn
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 17:34
 * @Version 1.0
 **/
@SpringBootTest
public class TestConn {
    @Resource
    DataSource dataSource;
    //test update

    @Test
    public void test01() throws SQLException {
        System.out.println(dataSource);
    }
}
