package com.keke.mapper;

import com.keke.domain.Message;
import com.keke.domain.MessageA;
import com.keke.domain.MessageDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    public void sendMessage(Message message);

    public List<MessageA> showMessageFromTeacher(String reciever);


}
