package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hugo on 3/25/2016.
 */
public class Employee implements Serializable {
    @JSONField(ordinal = 0)
    private int empNo;

    @JSONField(ordinal = 1)
    private String firstName;

    @JSONField(ordinal = 2)
    private String lastName;

    @JSONField(ordinal = 3)
    private Date birthDate;

    @JSONField(ordinal = 4)
    private Gender gender;

    @JSONField(ordinal = 5)
    private Date hireDate;

    public Employee() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empNo=" + empNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {
    M, F
}