package com.keke.mapper;

import com.keke.domain.CourseRes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseResMapper {

    public void insertUrl(CourseRes courseRes);

    public List<CourseRes> selectFile(@Param("cno")String cno,@Param("tno")String tno);

    public List<CourseRes> selectFileBySno(@Param("cno")String cno,@Param("tno")String tno,@Param("sno")String sno);

}
