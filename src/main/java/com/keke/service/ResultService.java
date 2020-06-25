package com.keke.service;

import com.keke.domain.Result;
import com.keke.domain.ResultSimple;
import com.keke.mapper.ResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultMapper resultMapper;

    public List<Result> selectPreparedResult(String tcoll){
        return resultMapper.selectPreparedResult(tcoll);
    }

    public List<Result> selectFinalResult(String tcoll){
        return resultMapper.selectFinalResult(tcoll);
    }

    public void deletePreparedResult(Result result){
        resultMapper.deletePreparedResult(result);
    }

    public void deleteFinalResult(Result result){
        resultMapper.deleteFinalResult(result);
    }

    public List<ResultSimple> selectCourseNum(String ccoll){
        return resultMapper.selectCourseNum(ccoll);
    }

    public List<Result> selectAllFinalResult(){
        return resultMapper.selectAllFinalResult();
    }

    public List<ResultSimple> selectAllCourseNum(){
        return resultMapper.selectAllCourseNum();
    }
}
