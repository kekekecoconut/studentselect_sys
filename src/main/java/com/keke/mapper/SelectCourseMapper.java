package com.keke.mapper;

import com.keke.domain.Course;
import com.keke.domain.FinalList;
import com.keke.domain.Result;
import com.keke.domain.ResultDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectCourseMapper {

    //想选这门课的学生list list.length()为想选这门课的学生数
    public List<Result> selectPrepared(@Param("rcno")String rcno, @Param("tno")String tno);
    //学院管理员：查看最终选课结果
    public List<Result> selectFinal(@Param("rcno")String rcno, @Param("tno")String tno);

    public List<ResultDetail> stuListFinal(@Param("cno") String cno,@Param("tno") String tno);

    //学生界面中已中签课程列表
    public List<ResultDetail> selectFinalStu(String rsno);

    public List<FinalList> finalStuList(@Param("cno") String cno,@Param("tno") String tno);

    //学生界面中未中签课程列表
    public List<ResultDetail> selectPreparedStu(String rsno);

    //当选课人数加已经选上人数小于或等于最大课程容量时，将预备选课表中该条记录删除，并插入最终选课结果列表
    public void insertFinalResult(Result result);

    //学生进行选课操作
    public void insertPreparedResult(Result result);

    //学生进行退课操作
    public void deleteFinalResult(Result result);

    //学生进行退课操作
    public void deletePreparedResult(Result result);



}
