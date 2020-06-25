package com.keke.mapper;

import com.keke.domain.Grade;
import com.keke.domain.GradeDetail;
import com.keke.domain.GradeTeacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {

    //通过先修课编号查询学号，看该同学学号是不是在里面
    public List<String> hasSno(String cno);

    //学生查看成绩列表
    public List<GradeDetail> showStuGrades(String sno);

    /*系统管理员查询的
    public List<Grade> showAllGrades();*/


    public void deleteGrade(@Param("sno") String sno,@Param("cno") String cno);

    public void updateGrade(@Param("sno") String sno,@Param("cno") String cno,@Param("grade") Integer grade);

    public void insertGrade(@Param("sno") String sno,@Param("cno") String cno,@Param("grade") Integer grade,@Param("tno")String tno);



    //系统管理员查看所有成绩
    public List<GradeDetail> showAllStuGrades();

    //学院管理员查看所有成绩
    public List<GradeDetail> showStuGradesColl(String sdept);

    public List<GradeDetail> selectGradeBySno(String sno);

    public List<GradeDetail> selectGradeByCname(@Param("sno")String sno,@Param("cname")String cname);

    public List<GradeTeacher> selectGradeByTno(@Param("tno") String tno);

    public List<GradeTeacher> selectGradeByTnoCname(@Param("tno")String tno,@Param("cname") String cname);

}
