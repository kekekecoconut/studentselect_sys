package com.keke.service;

import com.keke.domain.FinalList;
import com.keke.domain.Result;
import com.keke.domain.ResultDetail;
import com.keke.mapper.SelectCourseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCourseService {

    @Autowired
    private SelectCourseMapper selectCourseMapper;
    //想选这门课的学生list list.length()为想选这门课的学生数
    public List<Result> selectPrepared(@Param("rcno")String rcno, @Param("tno")String tno){
        return selectCourseMapper.selectPrepared(rcno,tno);
    }
    //学院管理员：查看最终选课结果
    public List<Result> selectFinal(@Param("rcno")String rcno, @Param("tno")String tno){
        return selectCourseMapper.selectFinal(rcno, tno);
    }

    public List<ResultDetail> stuListFinal(String cno,String tno){
        return selectCourseMapper.stuListFinal(cno, tno);
    }

    public List<FinalList> finalStuList(String cno, String tno){
        return selectCourseMapper.finalStuList(cno, tno);
    }


    //学生界面中已中签课程列表
    public List<ResultDetail> selectFinalStu(String rsno){
        return selectCourseMapper.selectFinalStu(rsno);
    }

    //学生界面中未中签课程列表
    public List<ResultDetail> selectPreparedStu(String rsno){
        return selectCourseMapper.selectPreparedStu(rsno);
    }

    //当选课人数加已经选上人数小于或等于最大课程容量时，将预备选课表中该条记录删除，并插入最终选课结果列表
    public void insertFinalResult(Result result){
        selectCourseMapper.insertFinalResult(result);
    }

    public void insertPreparedResult(Result result){
        selectCourseMapper.insertPreparedResult(result);
    }

    public void deletePreparedResult(Result result){
        selectCourseMapper.deletePreparedResult(result);
    }

    public void deleteFinalResult(Result result){
        selectCourseMapper.deleteFinalResult(result);
    }
}
