package com.keke.service;

import com.keke.domain.CourseRes;
import com.keke.mapper.CourseResMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseResService {

    @Autowired
    private CourseResMapper courseResMapper;

    public void insertUrl(CourseRes courseRes){
        courseResMapper.insertUrl(courseRes);
    }

    public List<CourseRes> selectFile(String cno, String tno){
        return courseResMapper.selectFile(cno, tno);
    }

    public List<CourseRes> selectFileBySno(@Param("cno")String cno,@Param("tno")String tno,@Param("sno")String sno){
        return courseResMapper.selectFileBySno(cno, tno, sno);
    }

}
