package com.keke.controller;

import com.keke.domain.Message;
import com.keke.domain.MessageDetail;
import com.keke.domain.Student;
import com.keke.domain.Teacher;
import com.keke.service.MessageService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping("/sendMessage")
    public Layui sendMessage(@RequestBody Message message){
        System.out.println(message);
        messageService.sendMessage(message);
        return Layui.data2(200,"发送成功！");
    }

    @RequestMapping("/listMessage")
    @ResponseBody
    public Layui listTeacherByno(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<MessageDetail> list = messageService.showMessageFromTeacher(student.getSname());
        return Layui.data(10,list);
    }

    @RequestMapping("/listMessageFromStudent")
    @ResponseBody
    public Layui listTeacherFromStudent(HttpServletRequest httpServletRequest){
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<MessageDetail> list = messageService.showMessageFromTeacher(teacher.getTname());
        return Layui.data(10,list);
    }


}
