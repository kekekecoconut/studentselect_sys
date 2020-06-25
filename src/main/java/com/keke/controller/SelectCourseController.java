package com.keke.controller;

import com.keke.domain.Course;
import com.keke.domain.CourseDetail;
import com.keke.domain.Result;
import com.keke.domain.Student;
import com.keke.service.CourseService;
import com.keke.service.GradeService;
import com.keke.service.ResultService;
import com.keke.service.SelectCourseService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/selectcourse")
public class SelectCourseController {

    @Autowired
    private SelectCourseService selectCourseService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private CourseService courseService;



    @ResponseBody
    @RequestMapping("/stuselect")
    public Layui stuChooseCourse(@RequestBody Course course, HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        System.out.println("当前选择课程时间："+course.getCtime());
        String rsno = student.getSno();
        String cpno = course.getCpno();
        //System.out.println("当前课程先修课编码为"+cpno);

        if(!cpno.equals("")){
            List<String> list_cpno = gradeService.hasSno(cpno);
            System.out.println("查询到的您是否上过："+list_cpno);
            if(list_cpno.size()==0)
                return Layui.data2(100,"您没有学习该课程的先修课程，不能进行选课！");
            else{
                List<String> time_list_pre = courseService.hasTimeInPre(rsno);
                System.out.println("在预备选择课表内:"+time_list_pre);
                for (String ctime :
                        time_list_pre) {
                    System.out.println("在预备选择课表内:"+ctime);
                    if(ctime.equals(course.getCtime())) {
                        return Layui.data2(300,"该课程与您已选课程冲突！不能进行选课操作！");
                    }
                }
                List<String> time_list_fin = courseService.hasTimeInFin(rsno);
                System.out.println("在选课成功课表内:"+time_list_fin);
                for (String ctime :
                        time_list_fin) {
                    System.out.println("在选课成功课表内:"+ctime);
                    System.out.println("相等吗？"+ctime==course.getCtime());
                    if(ctime.equals(course.getCtime())) {
                        System.out.println("相等吗？"+ctime==course.getCtime());
                        return Layui.data2(300,"该课程与您已选课程冲突！不能进行选课操作！");
                    }
                }
                Result result = new Result();
                result.setRcno(course.getCno());
                result.setRsno(student.getSno());
                result.setTno(course.getTno());
                selectCourseService.insertPreparedResult(result);
                System.out.println("选课成功！");
                return Layui.data2(200,"选课成功！");
            }
        }
        else{
                List<String> time_list_pre = courseService.hasTimeInPre(rsno);
                for (String ctime :
                        time_list_pre) {
                    if(ctime.equals(course.getCtime())) return Layui.data2(300,"该课程与您已选课程冲突！不能进行选课操作！");
                }
                List<String> time_list_fin = courseService.hasTimeInFin(rsno);
                for (String ctime :
                        time_list_fin) {
                    if(ctime.equals(course.getCtime())) return Layui.data2(300,"该课程与您已选课程冲突！不能进行选课操作！");
                }
                Result result = new Result();
                result.setRcno(course.getCno());
                result.setRsno(student.getSno());
                result.setTno(course.getTno());
                selectCourseService.insertPreparedResult(result);
                return Layui.data2(200,"选课成功！");
        }
    }

    @ResponseBody
    @RequestMapping("/drawstulist")
    public Layui drawStuList(@RequestBody CourseDetail courseDetail){
        String rcno = courseDetail.getCno();
        String tno = courseDetail.getTno();
        Integer maxnum = courseDetail.getMaxnum();
        List<Result> prepared_list = selectCourseService.selectPrepared(rcno,tno);
        List<Result> final_list = selectCourseService.selectFinal(rcno,tno);
        Integer prepared_num = prepared_list.size();
        Integer final_num = final_list.size();
        if(prepared_num + final_num <= maxnum){
            for (Result result :
                    prepared_list) {
                selectCourseService.insertFinalResult(result);
                selectCourseService.deletePreparedResult(result);
            }
        }else{
            if(final_num == maxnum){
                    return Layui.data2(100,"抽签失败！课程容量已满！");
            }else{
                for(int i=0;i<maxnum-final_num;i++) {
                    selectCourseService.insertFinalResult(prepared_list.get(i));
                    selectCourseService.deletePreparedResult(prepared_list.get(i));

                }
            }
        }
        return Layui.data2(200,"抽签成功！");
    }


}
