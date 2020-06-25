package com.keke.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keke.domain.CourseAll;
import com.keke.mapper.CourseAllMapper;
import com.keke.util.PageRequest;
import com.keke.util.PageResult;
import com.keke.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAllService {

    @Autowired
    CourseAllMapper courseAllMapper;

    public List<CourseAll> showAllCourses(){
        return courseAllMapper.showAllCourses();
    }

    public void insertCourse(CourseAll course){
        courseAllMapper.insertCourse(course);
    }

    public List<CourseAll> selectcByCno(String cno){
        return courseAllMapper.selectcByCno(cno);
    }

    public void deleteCourse(String cno){
        courseAllMapper.deleteCourse(cno);
    }

    public void updateCourse(CourseAll courseAll){
        courseAllMapper.updateCourse(courseAll);
    }

    public List<CourseAll> selectcByDept(String ccoll){
        return courseAllMapper.selectcByDept(ccoll);
    }

    public List<CourseAll> selectByType(String ctype){
        return courseAllMapper.selectByType(ctype);
    }

    private PageInfo<CourseAll> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<CourseAll> sysMenus = courseAllMapper.selectPage();
        return new PageInfo<CourseAll>(sysMenus);
    }

    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
}
