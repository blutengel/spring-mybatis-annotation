package com.example.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Hugo on 3/27/2016.
 */
@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
