package com.keke.controller;

import com.keke.Client;
import com.keke.domain.*;
import com.keke.service.MessageService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private static Client client = null;

    static {
        client = new Client();
    }

    @ResponseBody
    @RequestMapping("/sendMessage")
    public Layui sendMessage(@RequestBody Message message) throws Exception {
        System.out.println(message);
        String content = message.getContent();
        System.out.println(message);
        Random random = new Random();
        Integer rn = random.nextInt(100000000);
        message.setRn(rn);
        content = client.encrypt(content,rn);
        message.setContent(content);
        messageService.sendMessage(message);
        return Layui.data2(200,"发送成功！");
    }

    @RequestMapping("/listMessage")
    @ResponseBody
    public Layui listTeacherByno(HttpServletRequest httpServletRequest) throws Exception {
        Student student = (Student) httpServletRequest.getSession().getAttribute("session_type");
        List<MessageA> list = messageService.showMessageFromTeacher(student.getSname());
        List<MessageDetail> fl = new LinkedList<>();
        for (MessageA messageA:
               list ) {
            System.out.println(messageA);
            String content = client.decrypt(messageA.getRn());
            MessageDetail messageDetail = new MessageDetail();
            messageDetail.setContent(content);
            messageDetail.setReciever(messageA.getReciever());
            messageDetail.setSend_time(messageA.getSend_time());
            messageDetail.setSender(messageA.getSender());
            fl.add(messageDetail);
        }
        return Layui.data(10,fl);
    }

    @RequestMapping("/listMessageFromStudent")
    @ResponseBody
    public Layui listTeacherFromStudent(HttpServletRequest httpServletRequest) throws Exception {
        Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("session_type");
        List<MessageA> list = messageService.showMessageFromTeacher(teacher.getTname());
        List<MessageDetail> fl = new LinkedList<>();
        for (MessageA messageA:
                list ) {
            String content = client.decrypt(messageA.getRn());
            MessageDetail messageDetail = new MessageDetail();
            messageDetail.setContent(content);
            messageDetail.setReciever(messageA.getReciever());
            messageDetail.setSend_time(messageA.getSend_time());
            messageDetail.setSender(messageA.getSender());
            fl.add(messageDetail);
        }
        return Layui.data(10,fl);
    }


}
