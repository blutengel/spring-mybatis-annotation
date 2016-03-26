package com.example.Intercptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Hugo on 3/26/2016.
 */
public class PerformanceInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceInterceptor.class);

    private NamedThreadLocal<Long> timestamp = new NamedThreadLocal<Long>("Start time");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long begin = System.currentTimeMillis();
        timestamp.set(begin);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long end = System.currentTimeMillis();
        long begin = timestamp.get();
        long duration = end - begin;
        logger.warn(String.format("%s consume %d millis", request.getRequestURI(), duration));
    }
}
