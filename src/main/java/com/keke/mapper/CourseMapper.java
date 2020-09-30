package com.keke.mapper;

import com.keke.domain.Course;
import com.keke.domain.Grade;
import com.keke.domain.StudentCourse;
import com.keke.domain.TeacherCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    //通过学号查询到这个学生所选课程的所有的时间，判断想要选的课程时间是否在查询到的时间列表里面，在的话返回时间冲突
    public List<String> hasTimeInPre(String rsno);

    public List<String> hasTimeInFin(String rsno);


    //学生界面中所有可选择课程
    public List<Course> showAllCourses();

    public List<Course> showCoursesByCname(String cname);

    public List<TeacherCourse> showTeacherCourses(String tno);

    public List<StudentCourse> showStudentCourses(String sno);

    public void updateTeacherCourse(@Param("cintro") String cintro,@Param("cpno") String cpno,@Param("cno") String cno);


}
