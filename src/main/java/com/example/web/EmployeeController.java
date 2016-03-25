package com.example.web;

import com.alibaba.fastjson.JSON;
import com.example.domain.Employee;
import com.example.persistence.EmployeeDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Hugo on 3/25/2016.
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/page/{pageNum}/{pageSize}")
    @ResponseBody
    public String emp(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Employee> employees = employeeDao.findUsers();

        return JSON.toJSONString(employees);
    }
}
