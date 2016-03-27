package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Hugo on 3/27/2016.
 * 此类会拦截请求，并将请求委托给一个bean springSecurityFilterChain, 此bean不需要创建，只要@EnableWebSecurity即可
 */
//@Configuration
@EnableWebSecurity          // @EnableWebMvcSecurity is deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests 表示配置请求级别的安全
        // antMatchers 指定的路径需要被 authenticated，也可以指定拦截任何http方法
        // 匹配路径可以使用ant-style的路径，即?表单个字符，*表示0个或任意个字符，**表示0个或更多的目录
        // 如验证未通过，则跳转到login page

        http.formLogin().loginPage("/login.jsp")
                .and()
                .authorizeRequests()
                .antMatchers("/images/**").authenticated()
                .antMatchers("/emp/**").authenticated()
                .anyRequest().permitAll().and().csrf().disable();
    }

    // 配置user-details
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("alan").password("a").roles("admin","user").and()
                .withUser("denny").password("d").roles("user");

//        auth.jdbcAuthentication().dataSource(dataSource);
    }
}
