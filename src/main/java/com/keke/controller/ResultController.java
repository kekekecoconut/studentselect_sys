package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.ResultService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping("/preparedResult")
    @ResponseBody
    public Layui preparedResultBydept(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        List<Result> list = resultService.selectPreparedResult(admin.getAdept());
        return Layui.data(10,list);
    }

    @RequestMapping("/finalResult")
    @ResponseBody
    public Layui finalResultBydept(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        List<Result> list = resultService.selectFinalResult(admin.getAdept());
        return Layui.data(10,list);
    }

    @RequestMapping("/finalAllResult")
    @ResponseBody
    public Layui finalAllResultBydept(HttpServletRequest httpServletRequest){
        List<Result> list = resultService.selectAllFinalResult();
        return Layui.data(10,list);
    }

    @RequestMapping("/deletePreparedResult")
    @ResponseBody
    public Layui deletePreparedResult(@RequestBody Result result){
        resultService.deletePreparedResult(result);
        return Layui.data2(200,"删除成功！");
    }

    @RequestMapping("/deleteFinalResult")
    @ResponseBody
    public Layui deleteFinalResult(@RequestBody Result result){
        resultService.deleteFinalResult(result);
        return Layui.data2(200,"删除成功！");
    }

    @CrossOrigin
    @RequestMapping("/echarsShow")
    @ResponseBody
    public List<ResultSimple> resultData(HttpServletRequest httpServletRequest){
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("session_type");
        System.out.println(resultService.selectCourseNum(admin.getAdept()));
        return resultService.selectCourseNum(admin.getAdept());
    }

    @RequestMapping("/echarsShow_all")
    @ResponseBody
    public List<ResultSimple> resultAllData(HttpServletRequest httpServletRequest){
        System.out.println(resultService.selectAllCourseNum());
        return resultService.selectAllCourseNum();
    }


}
