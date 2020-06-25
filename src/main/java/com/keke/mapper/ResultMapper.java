package com.keke.mapper;

import com.keke.domain.Result;
import com.keke.domain.ResultSimple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultMapper {

    public List<Result> selectPreparedResult(String tcoll);

    public List<Result> selectFinalResult(String tcoll);

    public List<Result> selectAllFinalResult();

    public void deletePreparedResult(Result result);

    public void deleteFinalResult(Result result);

    public List<ResultSimple> selectCourseNum(String ccoll);

    public List<ResultSimple> selectAllCourseNum();




}

