package com.java.service;

import com.java.entity.*;

import java.util.List;

public interface Service {

    User selectUserName(String userName);

    int updateUserPwd(User user);

    User selectIdCard(String idCard);

    int SignUpUser(User user);

    List<User> selectUser();

    int deleteUser(int id);

    int updateUser(User user);

    User selectAcc(String acc);

    User selectIdNum(String idCard);

    int addUser(User user);

    int updateUserInformation(User user);

    User selectSingleAcc(String acc);

    List<Paper> selectAllPaperHead();

    int deletePaper(int id);

    int updatePaper(Paper paper);

    int changePaperStatus(Paper paper);

    int addPaper(Paper paper);

    List<Course> selectCourse();

    int deleteCourse(int id);

    int updateCourse(Course course);

    int addCourse(Course course);

    List<Message> selectMessage();

    Message selectSingleMessage(int id);

    int deleteMessage(int id);

    int updateMessage(Message m);

    int addMessage(Message m);

    int updateMessageCount(Message m);

    List<Tifo> selectTifo();

    int deleteTifo(int id);

    int updateTifo(Tifo tifo);

    int addTifo(Tifo tifo);

    List<T> selectT();

    int deleteT(int id);

    int updateT(T t);

    int addT(T t);

    List<Chat> selectChat();

    int addChat(Chat chat);

    List<Chat> selectSingleChat(String sender,String getter);

}
