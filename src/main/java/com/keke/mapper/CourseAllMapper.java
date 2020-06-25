package com.keke.mapper;

import com.keke.domain.CourseAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseAllMapper {

    //查看所有课程
    public List<CourseAll> showAllCourses();

    public List<CourseAll> selectPage();

    //根据学院查询
    public List<CourseAll> selectcByDept(String ccoll);

    //根据课程编号查询
    public List<CourseAll> selectcByCno(String cno);

    //根据课程种类查询
    public List<CourseAll> selectByType(String ctype);

    //新加一条课程
    public void insertCourse(CourseAll course);

    //删除一条课程
    public void deleteCourse(String cno);

    //更新课程信息
    public void updateCourse(CourseAll courseAll);


}
