package com.example.config;

import com.example.Intercptor.LoginInterceptor;
import com.example.Intercptor.MyInterceptor1;
import com.example.Intercptor.MyInterceptor2;
import com.example.Intercptor.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by zb1209144 on 2016/3/25.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.service", "com.example.web"})
public class WebConfig extends WebMvcConfigurerAdapter {

    // view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }

    // static resource
    // 通过继承WebMvcConfigurerAdapter并重写此方法，DispatcherServlet则会将静态资源请求转发到容器默认的servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    // 可以级联设置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/");
    }

    // 添加拦截器, order matters
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/emp/**");
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/emp/**");
        registry.addInterceptor(new PerformanceInterceptor()).addPathPatterns("/**");       // 也可以将拦截器添加@Component, 使其成为一个bean
    }
}
