package com.keke.service;

import com.keke.domain.CourseDetail;
import com.keke.mapper.CourseDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDetailService {

    @Autowired
    private CourseDetailMapper courseDetailMapper;

    public List<CourseDetail> selectCdByDept(String ccoll){
        return courseDetailMapper.selectCdByDept(ccoll);
    }

    public List<CourseDetail> selectCdByTno(String tno){
        return courseDetailMapper.selectCdByTno(tno);
    }

    public List<CourseDetail> selectCdByClass(String cclass){
        return courseDetailMapper.selectCdByClass(cclass);
    }

    public void insertCd(CourseDetail courseDetail){
        courseDetailMapper.insertCd(courseDetail);
    }

    public void deleteCd(String cno){
        courseDetailMapper.deleteCd(cno);
    }

    public void updateCd(CourseDetail courseDetail){
        courseDetailMapper.updateCd(courseDetail);
    }
}
