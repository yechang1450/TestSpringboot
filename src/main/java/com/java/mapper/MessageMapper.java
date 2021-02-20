package com.java.mapper;

import com.java.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    List<Message> selectMessage();

    Message selectSingleMessage(int id);

    int deleteMessage(int id);

    int updateMessage(Message m);

    int addMessage(Message m);

    int updateMessageCount(Message m);

}
