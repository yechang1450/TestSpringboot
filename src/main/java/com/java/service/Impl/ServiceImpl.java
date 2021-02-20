package com.java.service.Impl;

import com.java.entity.*;
import com.java.mapper.*;
import com.java.service.Service;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    @Resource
    UserMapper userMapper;
    @Resource
    PaperMapper paperMapper;
    @Resource
    CourseMapper courseMapper;
    @Resource
    MessageMapper messageMapper;
    @Resource
    TifoMapper tifoMapper;
    @Resource
    TMapper tMapper;
    @Resource
    ChatMapper chatMapper;

    @Override
    public User selectUserName(String userName) {
        return userMapper.selectUserName(userName);
    }

    @Override
    public int updateUserPwd(User user) {
        return userMapper.updateUserPwd(user);
    }

    @Override
    public User selectIdCard(String idCard) {
        return userMapper.selectIdCard(idCard);
    }

    @Override
    public int SignUpUser(User user) {
        return userMapper.SignUpUser(user);
    }

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User selectAcc(String acc) {
        return userMapper.selectAcc(acc);
    }

    @Override
    public User selectIdNum(String idCard) {
        return userMapper.selectIdNum(idCard);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUserInformation(User user) {
        return userMapper.updateUserInformation(user);
    }

    @Override
    public User selectSingleAcc(String acc) {
        return userMapper.selectSingleAcc(acc);
    }

    @Override
    public List<Paper> selectAllPaperHead() {
        return paperMapper.selectAllPaperHead();
    }

    @Override
    public int deletePaper(int id) {
        return paperMapper.deletePaper(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updatePaper(paper);
    }

    @Override
    public int changePaperStatus(Paper paper) {
        return paperMapper.changePaperStatus(paper);
    }

    @Override
    public int addPaper(Paper paper) {
        return paperMapper.addPaper(paper);
    }

    @Override
    public List<Course> selectCourse() {
        return courseMapper.selectCourse();
    }

    @Override
    public int deleteCourse(int id) {
        return courseMapper.deleteCourse(id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public List<Message> selectMessage() {
        return messageMapper.selectMessage();
    }

    @Override
    public Message selectSingleMessage(int id) {
        return messageMapper.selectSingleMessage(id);
    }

    @Override
    public int deleteMessage(int id) {
        return messageMapper.deleteMessage(id);
    }

    @Override
    public int updateMessage(Message m) {
        return messageMapper.updateMessage(m);
    }

    @Override
    public int addMessage(Message m) {
        return messageMapper.addMessage(m);
    }

    @Override
    public int updateMessageCount(Message m) {
        return messageMapper.updateMessageCount(m);
    }

    @Override
    public List<Tifo> selectTifo() {
        return tifoMapper.selectTifo();
    }

    @Override
    public int deleteTifo(int id) {
        return tifoMapper.deleteTifo(id);
    }

    @Override
    public int updateTifo(Tifo tifo) {
        return tifoMapper.updateTifo(tifo);
    }

    @Override
    public int addTifo(Tifo tifo) {
        return tifoMapper.addTifo(tifo);
    }

    @Override
    public List<T> selectT() {
        return tMapper.selectT();
    }

    @Override
    public int deleteT(int id) {
        return tMapper.deleteT(id);
    }

    @Override
    public int updateT(T t) {
        return tMapper.updateT(t);
    }

    @Override
    public int addT(T t) {
        return tMapper.addT(t);
    }

    @Override
    public List<Chat> selectChat() {
        return chatMapper.selectChat();
    }

    @Override
    public int addChat(Chat chat) {
        return chatMapper.addChat(chat);
    }

    @Override
    public List<Chat> selectSingleChat(String sender, String getter) {
        return chatMapper.selectSingleChat(sender,getter);
    }

}
