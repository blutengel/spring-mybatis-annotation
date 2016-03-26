package com.example.web;

import com.alibaba.fastjson.JSON;
import com.example.domain.Employee;
import com.example.domain.PageBean;
import com.example.persistence.EmployeeDao;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Hugo on 3/25/2016.
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/page/{pageNum}/{pageSize}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String emp(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Employee> employees = employeeDao.findUsers();

        return JSON.toJSONString(employees);
    }

    // 如果请求数据是通过json串传过来的，则可以通过@RequestBody将json转换为java对象
    @RequestMapping(value = "/pagi", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String emp(@RequestBody PageBean pageBean) {

        logger.warn(pageBean.toString());

        PageHelper.startPage(pageBean.getOffset(), pageBean.getLimit());
        List<Employee> employees = employeeDao.findUsers();

        return JSON.toJSONString(employees);
    }

    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            String picPath = "d:/tmp/upload/";
            String originalFilename = file.getOriginalFilename();

            String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            try {
                File dst = new File(picPath + newFilename);
                file.transferTo(dst);
                return "redirect:/welcome.jsp";
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        return "redirect:/login.jsp";
    }

}
