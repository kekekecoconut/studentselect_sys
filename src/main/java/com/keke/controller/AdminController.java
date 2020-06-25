package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.*;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static String dept = null;
    @Autowired
    private CourseAllService courseAllService;

    @Autowired
    private CourseDetailService courseDetailService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private GradeService gradeService;

    @ResponseBody
    @RequestMapping(value="/findAll")
    public Object findAll() {
        return courseAllService.showAllCourses();
    }

    @RequestMapping("/mainPage")
    public String mainPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "admin/admin_main";
    }

    @RequestMapping("/courseDetailPage")
    public String courseDetailPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "admin/collcoursedetail";
    }

    @RequestMapping("/stuManagePage")
    public String stuManagePage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "admin/stumanage_admin";
    }

    @RequestMapping("/teacherManagePage")
    public String teacherManagePage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name", admin.getAno());
        return "admin/tmanage_admin";
    }

    @RequestMapping("/welcomePage")
    public String welcomePage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/admin_welcome";
    }

    @RequestMapping("/drawCoursePage")
    public String drawCoursePage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/drawCourse";
    }

    @RequestMapping("/echartsPage")
    public String echartsPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/echarts";
    }

    @RequestMapping("/preparedResultPage")
    public String preparedResultPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/preparedresult_admin";
    }

    @RequestMapping("/finalResultPage")
    public String finalResultPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/finalresult_admin";
    }

    @RequestMapping("/showGradesPage")
    public String showGradesPage(HttpServletRequest httpServletRequest, Model model){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        model.addAttribute("name",admin.getAno());
        return "admin/showgrades_admin";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Layui list(@RequestParam Map<String, Object> params){
        List<CourseAll> menuList = courseAllService.showAllCourses();
        System.out.println(Layui.data(10, menuList));
        return Layui.data(10, menuList);
    }

    @RequestMapping("/listbytype")
    @ResponseBody
    public Layui listbytype(@RequestParam String ctype){
        System.out.println(ctype);
        List<CourseAll> list = courseAllService.selectByType(ctype);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/sureCourseDetailList")
    @ResponseBody
    public Layui courseDetailList(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        dept = admin.getAdept();
        List<CourseDetail> list = courseDetailService.selectCdByDept(dept);
        return Layui.data(10,list);
    }

    @RequestMapping("/listbyno")
    @ResponseBody
    public Layui listbyno(@RequestParam String cno){
        System.out.println(cno);
        List<CourseAll> list = courseAllService.selectcByCno(cno);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/listdetailbyno")
    @ResponseBody
    public Layui listCourseDetailByno(@RequestParam String cclass){
        System.out.println(cclass);
        List<CourseDetail> list = courseDetailService.selectCdByClass(cclass);
        System.out.println(list);
        System.out.println(Layui.data(10, list));
        return Layui.data(10, list);
    }

    @RequestMapping("/updatecoursedetail")
    @ResponseBody
    public Layui updateCourseDetail(@RequestBody CourseDetail courseDetail){
        System.out.println(courseDetail);
        courseDetailService.updateCd(courseDetail);
        return Layui.data2(200,"修改成功！");
    }

    @RequestMapping("/addCourseDetail")
    @ResponseBody
    public Layui addCourseDetail(@RequestBody CourseDetail courseDetail){
        System.out.println(courseDetail);
        courseDetailService.insertCd(courseDetail);
        return Layui.data2(200,"添加成功！");
    }

    @RequestMapping("/deletecoursedetail")
    @ResponseBody
    public Layui deleteCourseDetail(@RequestBody CourseDetail courseDetail){
        courseDetailService.deleteCd(courseDetail.getCno());
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Layui delete(@RequestBody CourseAll courseAll){
        courseAllService.deleteCourse(courseAll.getCno());
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Layui insert(@RequestBody CourseAll courseAll){
        courseAllService.insertCourse(courseAll);
        return Layui.data2(200,"插入成功！");
    }


    @RequestMapping("/update")
    @ResponseBody
    public Layui update(@RequestBody CourseAll courseAll){
        System.out.println(courseAll);
        courseAllService.updateCourse(courseAll);
        return Layui.data2(200,"修改成功！");
    }

    /*   @RequestMapping("/sureCourse2List")
    @ResponseBody
    public Layui user2List(){
        List<CourseAll> list = courseAllService.selectcByDept("计算机学院");
        return Layui.data(10,list);
    }

    public Layui coursealllist(HttpServletRequest request){
        Student stu = (Student) request.getSession().getAttribute("session_type");
        String sdept = stu.getSdept();
        return Layui.data(10,"成功！");
    }*/

    //进到admin页面后传入当前管理员院系名给课程表查询
    @RequestMapping("/sureCourseList")
    @ResponseBody
    public Layui userList(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        dept = admin.getAdept();
        List<CourseAll> list = courseAllService.selectcByDept(admin.getAdept());
        return Layui.data(10,list);
    }

    @RequestMapping("/studentList")
    @ResponseBody
    public Layui studentList(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        dept = admin.getAdept();
        List<Student> list = studentService.selectsByDept(dept);
        return Layui.data(10,list);
    }

    @RequestMapping("/gradeList")
    @ResponseBody
    public Layui gradeList(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        dept = admin.getAdept();
        List<GradeDetail> list = gradeService.showStuGradesColl(dept);
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
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        dept = admin.getAdept();
        List<Teacher> list = teacherService.selecttByTcoll(dept);
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




   /*@ResponseBody
    @GetMapping(value="/findPage")
    public Object findPage() {
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(2);
        pageQuery.setPageSize(1);
        return courseAllService.findPage(pageQuery);
    }*/
}
