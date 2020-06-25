package com.keke.mapper;

import com.keke.domain.CourseDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailMapper {

    public List<CourseDetail> selectCdByTno(String tno);

    //根据管理员的学院查询课程详细信息 一键抽签、删除该课、修改课程信息
    public List<CourseDetail> selectCdByDept(String ccoll);

    public List<CourseDetail> selectCdByClass(String cclass);

    public Integer getMaxNum(@Param("cno")String cno, @Param("tno")String tno);

    public void insertCd(CourseDetail courseDetail);

    public void deleteCd(String cno);

    public void updateCd(CourseDetail courseDetail);

    /***
     * 返回课程时间和所选择课程时间比较
     *
     *
     *
     */
}
