package com.example.Intercptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Hugo on 3/26/2016.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.warn("LoginInterceptor#preHandle");

        // get request url
        String uri = request.getRequestURI();
        // uri是公开地址，实际使用时将公开地址配置在文件中
        if (uri.indexOf("login") >= 0) {
            return true;
        }

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            // 已登录
            return true;
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
