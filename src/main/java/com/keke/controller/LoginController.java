package com.keke.controller;

import com.keke.domain.Admin;
import com.keke.domain.Highadmin;
import com.keke.domain.Student;
import com.keke.domain.Teacher;
import com.keke.service.AdminService;
import com.keke.service.CourseAllService;
import com.keke.service.StudentService;
import com.keke.service.TeacherService;
import com.keke.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    CourseAllService courseAllService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/k")
    public String getAll(){
        List<Student> list = studentService.showAllStudents();
        for (Student student :
                list) {
            System.out.println(student);
        }
        return "Ok!";
    }

    @ResponseBody
    @RequestMapping("/teacherLogin")
    public void teacherLogin(@RequestParam("tno") String tno, @RequestParam("tpassword") String tpassword, HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException {
        Teacher t = teacherService.teacherLogin(tno, tpassword);
        System.out.println(t);
        if(t == null) response.sendRedirect("/toIndex");
        else{
            httpServletRequest.getSession().setAttribute("session_name","teacher");
            httpServletRequest.getSession().setAttribute("session_type",t);
            response.sendRedirect("/teacher/welcomePage");
        }
    }

    @ResponseBody
    @RequestMapping("/studentLogin")
    public void studentLogin(@RequestParam("sno") String sno, @RequestParam("spassword") String spassword, HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException {
        Student stu = studentService.studentLogin(sno,spassword);
        System.out.println(stu);
        if(stu == null) response.sendRedirect("/toIndex");
        else{
            httpServletRequest.getSession().setAttribute("session_name","student");
            httpServletRequest.getSession().setAttribute("session_type",stu);
            response.sendRedirect("/student/welcomePage");
        }
    }

    @RequestMapping("/adminLogin")
    public void adminLogin(@RequestParam("ano") String ano, @RequestParam("apassword") String apassword, HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException {
        Admin admin = adminService.adminLogin(ano, apassword);
        System.out.println(admin);
        if(admin == null) response.sendRedirect("/toIndex");
        else{
            httpServletRequest.getSession().setAttribute("session_name","admin");
            httpServletRequest.getSession().setAttribute("session_type",admin);
            response.sendRedirect("/admin/welcomePage");
        }
    }

    @RequestMapping("/highadminLogin")
    public void highadminLogin(@RequestParam("ano") String ano, @RequestParam("apassword") String apassword, HttpServletRequest httpServletRequest,HttpServletResponse response) throws IOException {
        Highadmin admin = adminService.highadminLogin(ano,apassword);
        System.out.println(admin);
        if(admin == null) response.sendRedirect("/toIndex");
        else{
            httpServletRequest.getSession().setAttribute("session_name","highadmin");
            httpServletRequest.getSession().setAttribute("session_type",admin);
            response.sendRedirect("/highadmin/welcomePage");
        }
    }

    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_name");
        request.getSession().removeAttribute("session_type");
        response.sendRedirect("/toIndex");
    }



    @RequestMapping("/page")
    public String page(){
        return "page";
    }

}
