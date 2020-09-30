package com.keke.service;

import com.keke.domain.Message;
import com.keke.domain.MessageA;
import com.keke.domain.MessageDetail;
import com.keke.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public void sendMessage(Message message){
        messageMapper.sendMessage(message);
    }

    public List<MessageA> showMessageFromTeacher(String reciever){
        return messageMapper.showMessageFromTeacher(reciever);
    }
}
