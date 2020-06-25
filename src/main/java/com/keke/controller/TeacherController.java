package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.CourseResService;
import com.keke.service.CourseService;
import com.keke.service.GradeService;
import com.keke.service.SelectCourseService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SelectCourseService selectCourseService;

    public static String cno;

    public static String cname;




    @Autowired
    private CourseResService courseResService;

    @RequestMapping("/welcomePage")
    public String welcomePage(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        return "teacher/teacher_welcome";
    }

    @RequestMapping("/updateCoursePage")
    public String updateCourse(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        return "teacher/updatecourse";
    }

    @RequestMapping("/finalResultPage")
    public String finalResultPage(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        return "teacher/finalresult";
    }

    @RequestMapping("/stuGradePage")
    public String stuGradePage(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        //return "teacher/stugrade";
        return "teacher/newgrade";
    }

    @RequestMapping("/recievedMsgPage")
    public String recievedMsgPage(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        return "teacher/recievedmsg";
    }

    @RequestMapping("/addGrade")
    @ResponseBody
    public Layui addGrade(@RequestBody Grade grade, HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        System.out.println(grade);
        gradeService.insertGrade(grade.getSno(),grade.getCno(),grade.getGrade(),teacher.getTno());
        return Layui.data2(200,"插入成功！");
    }

    @RequestMapping("/sendMsgPage")
    public String sendMsgPage(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",teacher.getTname());
        return "teacher/sendmsg";
    }

    @ResponseBody
    @RequestMapping("/allTeacherCourses")
    public Layui teacherCourses(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<TeacherCourse> list = courseService.showTeacherCourses(teacher.getTno());
        System.out.println(list);
        return Layui.data(10,list);
    }

    @RequestMapping("/updateCourses")
    @ResponseBody
    public Layui updateCourses(@RequestBody TeacherCourse teacherCourse) {
        courseService.updateTeacherCourse(teacherCourse.getCintro(),teacherCourse.getCpno(),teacherCourse.getCno());
        return Layui.data2(200,"修改成功！");
    }

    @RequestMapping("/getData")
    @ResponseBody
    public void getData(@RequestBody TeacherCourse teacherCourse) {
        cno = teacherCourse.getCno();
        cname = teacherCourse.getCname();
        System.out.println(cno);
    }

    @ResponseBody
    @RequestMapping("/allCoursesFile")
    public Layui allCoursesFile(HttpServletRequest httpServletRequest, Model model){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        System.out.println(cno);
        System.out.println(teacher.getTno());
        List<CourseRes> list = courseResService.selectFile(cno,teacher.getTno());
        System.out.println(list);
        return Layui.data(10,list);
    }

    @RequestMapping("/gradeList_t")
    @ResponseBody
    public Layui gradeList_t(HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeTeacher> list = gradeService.selectGradeByTno(teacher.getTno());
        return Layui.data(10,list);
    }

    @RequestMapping("/gradeNameList_t")
    @ResponseBody
    public Layui gradeNameList_t(HttpServletRequest httpServletRequest, @RequestParam String cname){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeTeacher> list = gradeService.selectGradeByTnoCname(teacher.getTno(),cname);
        return Layui.data(10,list);
    }

    @RequestMapping("/gradeNameList")
    @ResponseBody
    public Layui gradeNameList(HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeTeacher> list = gradeService.selectGradeByTnoCname(teacher.getTno(),cname);
        return Layui.data(10,list);
    }

    @RequestMapping("/echarsShow")
    @ResponseBody
    public List<ResultSimple> resultData(HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        int count_wjg = 0; //不及格<60
        int count_gf = 0; //高分>90 <100
        int count_lh = 0; //良好 >80 <90
        int count_yb = 0; //一般 >60<80
        List<GradeTeacher> list = gradeService.selectGradeByTnoCname(teacher.getTno(),cname);
        for (GradeTeacher gt: list
             ) {
            if(gt.getGrade()<60) count_wjg++;
            else{
                if(gt.getGrade()>=60 && gt.getGrade()<80){
                    count_yb++;
                }else{
                    if(gt.getGrade()>=80 && gt.getGrade()<90){
                        count_lh++;
                    }else{
                        if(gt.getGrade()>=90) count_gf++;
                    }
                }
            }
        }

        ResultSimple rs_bjg = new ResultSimple();
        rs_bjg.setCname("不及格");
        rs_bjg.setCount(count_wjg);
        ResultSimple rs_gf = new ResultSimple();
        rs_gf.setCname("高分");
        rs_gf.setCount(count_gf);
        ResultSimple rs_lh = new ResultSimple();
        rs_lh.setCname("良好");
        rs_lh.setCount(count_lh);
        ResultSimple rs_yb = new ResultSimple();
        rs_yb.setCname("一般");
        rs_yb.setCount(count_yb);
        List<ResultSimple> result_list =new LinkedList<>();
        result_list.add(rs_bjg);
        result_list.add(rs_gf);
        result_list.add(rs_lh);
        result_list.add(rs_yb);
        return result_list;
    }

    @RequestMapping("/showStudent")
    @ResponseBody
    public Layui showStudent(HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<FinalList> list = selectCourseService.finalStuList(cno, teacher.getTno());
        System.out.println(list);
        return Layui.data(10,list);
    }



}
