package com.keke.interceptor;

import com.keke.domain.Admin;
import com.keke.domain.Highadmin;
import com.keke.domain.Student;
import com.keke.domain.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        String name = (String) request.getSession().getAttribute("session_name");
        if ("admin".equals(name)) {
            Admin admin = (Admin) request.getSession().getAttribute("session_type");
            if (admin.getAno() == null) {
                System.out.println("尚未登录，跳转到登录页面");
                System.out.println("已成功拦截并转发跳转");
                response.sendRedirect(request.getContextPath() + "/toIndex");
                return false;
            }
            System.out.println("合格不需要拦截，放行");
            return true;
        } else {
            if ("student".equals(name)) {
                Student student = (Student) request.getSession().getAttribute("session_type");
                if (student.getSname() == null) {
                    System.out.println("尚未登录，跳转到登录页面");
                    System.out.println("已成功拦截并转发跳转");
                    response.sendRedirect(request.getContextPath() + "/toIndex");
                    return false;
                }
                System.out.println("合格不需要拦截，放行");
                return true;
            } else {
                if ("teacher".equals(name)) {
                    Teacher teacher = (Teacher) request.getSession().getAttribute("session_type");
                    if (teacher.getTname() == null) {
                        System.out.println("尚未登录，跳转到登录页面");
                        System.out.println("已成功拦截并转发跳转");
                        response.sendRedirect(request.getContextPath() + "/toIndex");
                        return false;
                    }
                    System.out.println("合格不需要拦截，放行");
                    return true;
                } else {
                    if ("highadmin".equals(name)) {
                        Highadmin admin = (Highadmin) request.getSession().getAttribute("session_type");
                        if (admin.getAno() == null) {
                            System.out.println("尚未登录，跳转到登录页面");
                            System.out.println("已成功拦截并转发跳转");
                            response.sendRedirect(request.getContextPath() + "/toIndex");
                            return false;
                        }
                        System.out.println("合格不需要拦截，放行");
                        return true;
                    }
                }
            }
            return false;
        }

    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
