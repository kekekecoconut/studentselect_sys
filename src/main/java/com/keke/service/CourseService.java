package com.keke.service;


import com.keke.domain.Course;
import com.keke.domain.StudentCourse;
import com.keke.domain.TeacherCourse;
import com.keke.mapper.CourseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    //通过学号查询到这个学生所选课程的所有的时间，判断想要选的课程时间是否在查询到的时间列表里面，在的话返回时间冲突
    public List<String> hasTimeInPre(String rsno){
        return courseMapper.hasTimeInPre(rsno);
    }

    //通过学号查询到这个学生所选课程的所有的时间，判断想要选的课程时间是否在查询到的时间列表里面，在的话返回时间冲突
    public List<String> hasTimeInFin(String rsno){
        return courseMapper.hasTimeInFin(rsno);
    }

    //学生界面中所有可选择课程
    public List<Course> showAllCourses(){
        return courseMapper.showAllCourses();
    }

    public List<Course> showCoursesByCname(String cname){
        return courseMapper.showCoursesByCname(cname);
    }

    public List<TeacherCourse> showTeacherCourses(String tno){
        return courseMapper.showTeacherCourses(tno);
    }

    public List<StudentCourse> showStudentCourses(String sno){
        return courseMapper.showStudentCourses(sno);
    }

    public void updateTeacherCourse(String cintro, String cpno, String cno){
        courseMapper.updateTeacherCourse(cintro, cpno, cno);
    }
}
