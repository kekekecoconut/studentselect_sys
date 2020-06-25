package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.CourseResService;
import com.keke.service.CourseService;
import com.keke.service.GradeService;
import com.keke.service.SelectCourseService;
import com.keke.util.Layui;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectCourseService selectCourseService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseResService courseResService;

    public static String cno;

    public static String cname;

    public static String tno;

    public static String tname;

    @RequestMapping("/welcomePage")
    public String welcomePage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/student_welcome";
    }

    @RequestMapping("/selfDataPage")
    public String selfDataPage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        model.addAttribute("sex",student.getSsex());
        model.addAttribute("sdept",student.getSdept());
        model.addAttribute("sclass",student.getSclass());
        return "student/selfdata_stu";
    }

    @RequestMapping("/coursePage")
    public String updateCourse(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/coursedetail_stu";
    }

    @RequestMapping("/selectablePage")
    public String selectablePage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/selectable_stu";
    }

    @RequestMapping("/finalResultPage")
    public String finalResultPage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/finalresult_stu";
    }

    @RequestMapping("/preparedResultPage")
    public String preparedResultPage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/preparedsesult_stu";
    }

    @RequestMapping("/gradePage")
    public String gradePage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/grade_stu";
    }

    @RequestMapping("/recievedMsgPage")
    public String recievedMsgPage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/recievedmsg_stu";
    }

    @RequestMapping("/sendMasgPage")
    public String sendMasgPage(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",student.getSname());
        return "student/sendmsg_stu";
    }

    @RequestMapping("/selectableList")
    @ResponseBody
    public Layui selectableList(HttpServletRequest httpServletRequest){
        List<Course> list = courseService.showAllCourses();
        return Layui.data(10,list);
    }

    @RequestMapping("/selectableListByCname")
    @ResponseBody
    public Layui selectableListByCname(HttpServletRequest httpServletRequest, @RequestParam String cname){
        List<Course> list = courseService.showCoursesByCname(cname);
        return Layui.data(10,list);
    }

    @ResponseBody
    @RequestMapping("/selectFinalStu")
    public Layui selectFinalStu(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<ResultDetail> list = selectCourseService.selectFinalStu(student.getSno());
        return Layui.data(10,list);
    }

    @ResponseBody
    @RequestMapping("/selectPreparedStu")
    public Layui selectPreparedStu(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<ResultDetail> list = selectCourseService.selectPreparedStu(student.getSno());
        return Layui.data(10,list);
    }

    @RequestMapping("/deletePreparedResult")
    @ResponseBody
    public Layui deletePreparedResult(@RequestBody ResultDetail resultDetail,HttpServletRequest httpServletRequest){
        System.out.println(resultDetail);
        Result result = new Result();
        result.setTno(resultDetail.getTno());
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        result.setRsno(student.getSno());
        result.setRcno(resultDetail.getCno());
        System.out.println(result);
        selectCourseService.deletePreparedResult(result);
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/deleteFinalResult")
    @ResponseBody
    public Layui deleteFinalResult(@RequestBody ResultDetail resultDetail,HttpServletRequest httpServletRequest){
        Result result = new Result();
        result.setTno(resultDetail.getTno());
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        result.setRsno(student.getSno());
        result.setRcno(resultDetail.getCno());
        selectCourseService.deleteFinalResult(result);
        return Layui.data2(200,"删除成功！");
    }

    @ResponseBody
    @RequestMapping("/allStudentCourses")
    public Layui teacherCourses(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<StudentCourse> list = courseService.showStudentCourses(student.getSno());
        System.out.println(list);
        return Layui.data(10,list);
    }

    @RequestMapping("/gradeList")
    @ResponseBody
    public Layui gradeList(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeDetail> list = gradeService.selectGradeBySno(student.getSno());
        return Layui.data(10,list);
    }

    @RequestMapping("/listGradeByCname")
    @ResponseBody
    public Layui listGradeByCname(@RequestParam String cname,HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeDetail> list = gradeService.selectGradeByCname(student.getSno(),cname);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/getData")
    @ResponseBody
    public void getData(@RequestBody StudentCourse studentCourse) {
        cno = studentCourse.getCno();
        cname = studentCourse.getCname();
        tno = studentCourse.getTno();
        tname = studentCourse.getTname();

        System.out.println(cno);
    }

    @ResponseBody
    @RequestMapping("/allCoursesFile")
    public Layui allCoursesFile(HttpServletRequest httpServletRequest, Model model){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        System.out.println(cno);
        System.out.println(tno);
        List<CourseRes> list = courseResService.selectFile(cno,tno);
        System.out.println(list);
        return Layui.data(10,list);
    }



    //selectFinalStu


}
