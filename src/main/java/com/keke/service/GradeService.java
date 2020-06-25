package com.keke.service;

import com.keke.domain.GradeDetail;
import com.keke.domain.GradeTeacher;
import com.keke.mapper.GradeMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    public List<String> hasSno(String cno){
        return gradeMapper.hasSno(cno);
    }

    /*系统管理员查询的
    public List<Grade> showAllGrades(){
        return gradeMapper.showAllGrades();
    }*/

    public void deleteGrade(String sno, String cno){
        gradeMapper.deleteGrade(sno, cno);
    }

    public List<GradeDetail> showStuGrades(String sno){
        return gradeMapper.showStuGrades(sno);
    }
    //系统管理员查看所有成绩
    public List<GradeDetail> showAllStuGrades(){
        return gradeMapper.showAllStuGrades();
    }

    //学院管理员查看所有成绩
    public List<GradeDetail> showStuGradesColl(String sdept){
        return gradeMapper.showStuGradesColl(sdept);
    }

    public void updateGrade(String sno, String cno, Integer grade){
        gradeMapper.updateGrade(sno, cno, grade);
    }

    public void insertGrade(String sno,String cno,Integer grade,String tno){
        gradeMapper.insertGrade(sno, cno, grade,tno);
    }

    public List<GradeDetail> selectGradeBySno(String sno){
        return gradeMapper.selectGradeBySno(sno);
    }

    public List<GradeDetail> selectGradeByCname(String sno,String cname){
        return gradeMapper.selectGradeByCname(sno, cname);
    }

    public List<GradeTeacher> selectGradeByTno(String tno){
        return gradeMapper.selectGradeByTno(tno);
    }
    public List<GradeTeacher> selectGradeByTnoCname(String tno, String cname){
        return gradeMapper.selectGradeByTnoCname(tno,cname);
    }


}
