package com.example.persistence;

import com.example.config.RootConfig;
import com.example.config.WebConfig;
import com.example.domain.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hugo on 3/25/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
//@WebAppConfiguration        // 添加web环境，不然可能会出现异常A ServletContext is required to configure default servlet handling
public class EmployeeDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoTest.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindUsers() throws Exception {

        PageHelper.startPage(1, 10);
        List<Employee> employees = employeeDao.findUsers();

        assertEquals(10, employees.size());

        Page<Employee> page = (Page<Employee>) employees;

        logger.warn(employees.get(0).toString());
//        logger.warn(page.toString());
    }
}