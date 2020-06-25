package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.GradeService;
import com.keke.service.StudentService;
import com.keke.service.TeacherService;
import com.keke.util.Layui;
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
@RequestMapping("/highadmin")
public class HighadminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/welcomePage")
    public String welcomePage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "highadmin/highadmin_welcome";
    }

    @RequestMapping("/finalResultPage")
    public String finalResultPage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "highadmin/finalresult_highadmin";
    }

    @RequestMapping("/stuManagePage")
    public String stuManagePage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "highadmin/stumanage_highadmin";
    }

    @RequestMapping("/teacherManagePage")
    public String teacherManagePage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "highadmin/tmanage_highadmin";
    }

    @RequestMapping("/showGradesPage")
    public String showGradesPage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "highadmin/showgrades_highadmin";
    }

    @RequestMapping("/echartsPage")
    public String echartsPage(HttpServletRequest httpServletRequest, Model model){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "highadmin/echarts_highadmin";
    }

    @RequestMapping("/studentList")
    @ResponseBody
    public Layui studentList(HttpServletRequest httpServletRequest){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        List<Student> list = studentService.showAllStudents();
        return Layui.data(10,list);
    }

    @RequestMapping("/listStudentByno")
    @ResponseBody
    public Layui listStudentByno(@RequestParam String sno){
        System.out.println(sno);
        List<Student> list = studentService.selectsBySno(sno);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public Layui deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student.getSno());
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Layui updateStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.updateStudent(student);
        return Layui.data2(200,"修改成功！");
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public Layui addStudent(@RequestBody Student student){
        studentService.insertStudent(student);
        return Layui.data2(200,"插入成功！");
    }

    @RequestMapping("/teacherList")
    @ResponseBody
    public Layui teacherList(HttpServletRequest httpServletRequest){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        List<Teacher> list = teacherService.showAllTeacher();
        return Layui.data(10,list);
    }

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public Layui updateTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher);
        teacherService.updateTeacher(teacher);
        return Layui.data2(200,"修改成功！");
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public Layui deleteTeacher(@RequestBody Teacher teacher){
        teacherService.deleteTeacher(teacher.getTno());
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/addTeacher")
    @ResponseBody
    public Layui addTeacher(@RequestBody Teacher teacher){
        teacherService.insertTeacher(teacher);
        return Layui.data2(200,"插入成功！");
    }

    @RequestMapping("/listTeacherByno")
    @ResponseBody
    public Layui listTeacherByno(@RequestParam String tno){
        System.out.println(tno);
        List<Teacher> list = teacherService.selecttByTno(tno);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/updateGrade")
    @ResponseBody
    public Layui updateGrade(@RequestBody GradeShort gradeShort) {
        gradeService.updateGrade(gradeShort.getSno(), gradeShort.getCno(), gradeShort.getGrade());
        return Layui.data2(200,"修改成功！");
    }

    @RequestMapping("/deleteGrade")
    @ResponseBody
    public Layui deleteGrade(@RequestBody GradeDetail gradeDetail){
        gradeService.deleteGrade(gradeDetail.getSno(),gradeDetail.getCno());
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/addGrade")
    @ResponseBody
    public Layui addGrade(@RequestBody Grade grade){
        System.out.println(grade);
        gradeService.insertGrade(grade.getSno(),grade.getCno(),grade.getGrade(),grade.getTno());
        return Layui.data2(200,"插入成功！");
    }


    @RequestMapping("/listGradeByno")
    @ResponseBody
    public Layui listGradeByno(@RequestParam String sno){
        List<GradeDetail> list = gradeService.selectGradeBySno(sno);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/gradeList")
    @ResponseBody
    public Layui gradeList(HttpServletRequest httpServletRequest){
        Highadmin admin = (Highadmin) httpServletRequest.getSession().getAttribute("session_type");
        List<GradeDetail> list = gradeService.showAllStuGrades();
        return Layui.data(10,list);
    }
}
