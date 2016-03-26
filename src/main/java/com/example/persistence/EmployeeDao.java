package com.example.persistence;

import com.example.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hugo on 3/25/2016.
 */
public interface EmployeeDao {
    List<Employee> findUsers();
}
