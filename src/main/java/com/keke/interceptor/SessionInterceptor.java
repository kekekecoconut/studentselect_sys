package com.keke.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SessionInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList();
        list.add("/toIndex");
        list.add("/teacherLogin");
        list.add("/studentLogin");
        list.add("/adminLogin");
        list.add("/highadminLogin");
        list.add("/mainPage");
        list.add("/static/**");
        list.add("/");
        list.add("/k");
        list.add("/courseRes/**");
        list.add("/main");
        list.add("/first");
        list.add("/intro");
        list.add("/contact");
        list.add("/webchat/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }
}
