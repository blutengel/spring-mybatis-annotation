package com.example.persistence;

import com.example.domain.User;

import java.util.List;

/**
 * Created by zb1209144 on 2016/3/25.
 */
//@Repository
public interface UserDao {

    //    @Results({
//            @Result(column = "username", property = "username"),
//            @Result(column = "password", property = "password")
//    })
//    @Select("select username, password from user")
    List<User> findAllUsers();
}
