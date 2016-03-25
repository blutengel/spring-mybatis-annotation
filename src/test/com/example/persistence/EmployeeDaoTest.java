package com.example.persistence;

import com.alibaba.fastjson.JSON;
import com.example.config.RootConfig;
import com.example.domain.Employee;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hugo on 3/25/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
//@WebAppConfiguration          // 添加web环境，不然可能会出现异常A ServletContext is required to configure default servlet handling
public class EmployeeDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoTest.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindUsers() throws Exception {

        PageHelper.startPage(1, 10);
        List<Employee> employees = employeeDao.findUsers();     // 返回的Page

        logger.warn(employees.toString());

//        Page<Employee> page = (Page<Employee>) employees;
//        assertTrue(employees instanceof Page);

        logger.warn(JSON.toJSONString(employees));
    }
}