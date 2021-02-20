package com.java.mapper;

import com.java.entity.Chat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMapper {

    List<Chat> selectChat();

    int addChat(Chat chat);

    List<Chat> selectSingleChat(String aName,String friend);
}
