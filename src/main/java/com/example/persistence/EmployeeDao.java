package com.example.persistence;

import com.example.domain.Employee;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Hugo on 3/25/2016.
 */
public interface EmployeeDao {
    List<Employee> findUsers();
}
