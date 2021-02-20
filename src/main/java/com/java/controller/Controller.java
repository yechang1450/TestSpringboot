package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.java.entity.*;
import com.java.service.Service;
import com.java.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Service service;

    //Login
    @RequestMapping(value = "selectUserName/acc={userName}", produces = "text/json;charset=utf-8")
    public String selectUserName(@PathVariable String userName) {
        User user = service.selectUserName(userName);
        //System.out.println(user.toString());
        return user.toString();
    }
    @RequestMapping(value = "updateUserPwd/acc={acc}&&pwd={pwd}")
    public void updateUserPwd(@PathVariable String acc, @PathVariable String pwd) {
        User user = new User();
        user.setUserName(acc);
        user.setPassWord(pwd);
        service.updateUserPwd(user);
        System.out.println("user密码修改成功,acc:"+acc);
    }
    @RequestMapping(value = "selectIdCard/idCard={idCard}", produces = "text/json;charset=utf-8")
    public String selectIdCard(@PathVariable String idCard) {
        User user = service.selectIdCard(idCard);
        System.out.println(user.toString());
        return user.toString();
    }
    @RequestMapping(value = "SignUpUser/acc={acc}&&pwd={pwd}&&idCard={idCard}&&Grade={grade}")
    public void SignUpUser(@PathVariable String acc, @PathVariable String pwd, @PathVariable String idCard, @PathVariable int grade) {
        User user = new User();
        user.setUserName(acc);
        user.setPassWord(pwd);
        user.setIdCard(idCard);
        user.setGrade(grade);
        service.SignUpUser(user);
        System.out.println("user用户添加成功,Acc:"+acc);
    }
    //User
    @RequestMapping(value = "selectUser", produces = "text/json;charset=utf-8")
    public String selectUser() throws Exception {
        List<User> userData = service.selectUser();
        String[] column = {"id", "userName", "passWord", "idCard", "grade", "email", "realName", "personShow"};
        String data = ObjtoLayJson.ListtoJson(userData, column);
        //System.out.println(data);
        return data;
    }
    @RequestMapping(value = "deleteUser/id={id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        System.out.println("user删除成功,id:"+id);
    }
    @RequestMapping(value = "updateUser/{id}&&{acc}&&{pwd}&&{idCard}&&{grade}&&{email}&&{realName}&&{personShow}")
    public String updateUser(@PathVariable int id, @PathVariable String acc, @PathVariable String pwd, @PathVariable String idCard, @PathVariable int grade, @PathVariable String email, @PathVariable String realName, @PathVariable String personShow) {
        User user = new User();
        user.setId(id);
        user.setUserName(acc);
        user.setPassWord(pwd);
        user.setIdCard(idCard);
        user.setGrade(grade);
        user.setEmail(email);
        user.setRealName(realName);
        user.setPersonShow(personShow);
        service.updateUser(user);
        System.out.println("user信息修改成功,id:"+id);
        return service.selectUserName(acc).toString();
    }
    @RequestMapping(value = "selectAcc/{acc}")
    public String selectAcc(@PathVariable String acc) {
        User user = service.selectAcc(acc);
        if(user != null){
            return "1";
        }else{
            return "0";
        }
    }
    @RequestMapping(value = "selectSingleAcc/{acc}")
    public String selectSingleAcc(@PathVariable String acc) {
        return service.selectSingleAcc(acc).toString();
    }
    @RequestMapping(value = "selectIdNum/{idCard}")
    public String selectIdNum(@PathVariable String idCard) {
        User user = service.selectIdNum(idCard);
        if(user != null){
            return "1";
        }else{
            return "0";
        }
    }
    @RequestMapping(value = "addUser/{acc}&&{pwd}&&{idCard}&&{grade}&&{email}&&{realName}&&{personShow}")
    public void addUser(@PathVariable String acc, @PathVariable String pwd, @PathVariable String idCard, @PathVariable int grade, @PathVariable String email, @PathVariable String realName, @PathVariable String personShow) {
        User user = new User();
        user.setUserName(acc);
        user.setPassWord(pwd);
        user.setIdCard(idCard);
        user.setGrade(grade);
        user.setEmail(email);
        user.setRealName(realName);
        user.setPersonShow(personShow);
        service.addUser(user);
        System.out.println("user用户添加成功,Acc:"+acc);
    }
    @RequestMapping(value = "updateUserInformation/{acc}&&{email}&&{realName}&&{personShow}", produces = "text/json;charset=utf-8")
    public void updateUserInformation(@PathVariable String acc, @PathVariable String email, @PathVariable String realName, @PathVariable String personShow) {
        User user = new User();
        user.setUserName(acc);
        user.setEmail(email);
        user.setRealName(realName);
        user.setPersonShow(personShow);
        service.updateUserInformation(user);
        System.out.println("user信息修改成功,acc:"+acc);
    }
    //Paper
    @RequestMapping(value = "selectAllPaper", produces = "text/json;charset=utf-8")
    public String selectAllPaperHead() throws Exception {
        List<Paper> paperHead = service.selectAllPaperHead();
        if(paperHead != null){
            String[] column = {"id", "course", "type", "name", "time", "paperStatus"};
            String data = ObjtoLayJson.ListtoJson(paperHead, column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "deletePaper/{id}")
    public void deletePaper(@PathVariable int id) {
        service.deletePaper(id);
        System.out.println("paper删除成功,id:"+id);
    }
    @RequestMapping(value = "updatePaper/{id}&&{course}&&{type}&&{upname}&&{time}&&{paperStatus}")
    public void updatePaper(@PathVariable int id, @PathVariable String course, @PathVariable String type, @PathVariable String upname, @PathVariable int time, @PathVariable String paperStatus) {
        Paper paper = new Paper();
        paper.setId(id);
        paper.setCourse(course);
        paper.setType(type);
        paper.setName(upname);
        paper.setTime(time);
        paper.setPaperStatus(paperStatus);
        service.updatePaper(paper);
        System.out.println("paper信息修改成功,id:"+id);
    }
    @RequestMapping(value = "changePaperStatus/{id}&&{paperStatus}")
    public void changePaperStatus(@PathVariable int id, @PathVariable String paperStatus) {
        Paper paper = new Paper();
        paper.setId(id);
        paper.setPaperStatus(paperStatus);
        service.changePaperStatus(paper);
        System.out.println("paper状态修改成功,id:"+id);
    }
    @RequestMapping(value = "addPaper/{course}&&{type}&&{upname}&&{time}&&{paperStatus}")
    public void addPaper(@PathVariable String course, @PathVariable String type, @PathVariable String upname, @PathVariable int time, @PathVariable String paperStatus) {
        Paper paper = new Paper();
        paper.setCourse(course);
        paper.setType(type);
        paper.setName(upname);
        paper.setTime(time);
        paper.setPaperStatus(paperStatus);
        service.addPaper(paper);
        System.out.println("paper用户添加成功,course:"+course);
    }
    //Course
    @RequestMapping(value = "selectCourse", produces = "text/json;charset=utf-8")
    public String selectCourse() throws Exception {
        List<Course> course = service.selectCourse();
        if(course != null){
            String[] column = {"id", "courseName", "courseNum", "grade"};
            String data = ObjtoLayJson.ListtoJson(course, column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "deleteCourse/{id}")
    public void deleteCourse(@PathVariable int id) {
        service.deleteCourse(id);
        System.out.println("course删除成功,id:"+id);
    }
    @RequestMapping(value = "updateCourse/{id}&&{courseName}&&{courseNum}&&{grade}")
    public void updateCourse(@PathVariable int id, @PathVariable String courseName, @PathVariable String courseNum, @PathVariable int grade) {
        Course course = new Course();
        course.setId(id);
        course.setCourseName(courseName);
        course.setCourseNum(courseNum);
        course.setGrade(grade);
        service.updateCourse(course);
        System.out.println("course信息修改成功,id:"+id);
    }
    @RequestMapping(value = "addCourse/{courseName}&&{courseNum}&&{grade}")
    public void addCourse(@PathVariable String courseName, @PathVariable String courseNum, @PathVariable int grade) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNum(courseNum);
        course.setGrade(grade);
        service.addCourse(course);
        System.out.println("course用户添加成功,courseName:"+courseName);
    }
    //Message
    @RequestMapping(value = "selectMessage", produces = "text/json;charset=utf-8")
    public String selectMessage() throws Exception {
        List<Message> message = service.selectMessage();
        if(message != null){
            String[] column = {"id", "message", "deadline", "submitter", "submitTime", "countNum", "student"};
            String data = ObjtoLayJson.ListtoJson(message, column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "selectSingleMessage/{id}", produces = "text/json;charset=utf-8")
    public String selectSingleMessage(@PathVariable int id){
        Message message = service.selectSingleMessage(id);
        String data = JSON.toJSONString(message);
        return data;
    }
    @RequestMapping(value = "deleteMessage/{id}")
    public void deleteMessage(@PathVariable int id) {
        service.deleteMessage(id);
        System.out.println("Message删除成功,id:"+id);
    }
    @RequestMapping(value = "updateMessage/{id}&&{message}&&{deadline}&&{submitter}&&{submitTime}&&{countNum}&&{student}")
    public void updateMessage(@PathVariable int id, @PathVariable String message, @PathVariable String deadline, @PathVariable String submitter, @PathVariable String submitTime, @PathVariable int countNum, @PathVariable String student) {
        Message m = new Message();
        m.setId(id);
        m.setMessage(message);
        m.setDeadline(deadline);
        m.setSubmitter(submitter);
        m.setSubmitTime(submitTime);
        m.setCountNum(countNum);
        m.setStudent(student);
        service.updateMessage(m);
        System.out.println("Message修改成功,id:"+id);
    }
    @RequestMapping(value = "updateMessageStatus/{id}&&{countNum}")
    public void updateMessageStatus(@PathVariable int id, @PathVariable int countNum) {
        Message m = new Message();
        m.setId(id);
        m.setCountNum(countNum);
        service.updateMessageCount(m);
        System.out.println("MessageStatus修改成功,id:"+id);
    }
    @RequestMapping(value = "addMessage/{message}&&{deadline}&&{submitter}&&{submitTime}&&{countNum}&&{student}")
    public void addMessage(@PathVariable String message, @PathVariable String deadline, @PathVariable String submitter, @PathVariable String submitTime, @PathVariable int countNum, @PathVariable String student) {
        Message m = new Message();
        m.setMessage(message);
        m.setDeadline(deadline);
        m.setSubmitter(submitter);
        m.setSubmitTime(submitTime);
        m.setCountNum(countNum);
        m.setStudent(student);
        service.addMessage(m);
        System.out.println("Message添加成功,message:"+message);
    }
    //Tifo
    @RequestMapping(value = "selectTifo", produces = "text/json;charset=utf-8")
    public String selectTifo() throws Exception {
        List<Tifo> tifo = service.selectTifo();
        if(tifo != null){
            String[] column = {"id", "paperName", "type", "name", "tNum"};
            String data = ObjtoLayJson.ListtoJson(tifo, column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "deleteTifo/{id}")
    public void deleteTifo(@PathVariable int id) {
        service.deleteTifo(id);
        System.out.println("Tifo删除成功,id:"+id);
    }
    @RequestMapping(value = "updateTifo/{id}&&{paperName}&&{type}&&{name}&&{tNum}")
    public void updateTifo(@PathVariable int id, @PathVariable String paperName, @PathVariable String type, @PathVariable String name, @PathVariable int tNum) {
        Tifo tifo = new Tifo();
        tifo.setId(id);
        tifo.setPaperName(paperName);
        tifo.setType(type);
        tifo.setName(name);
        tifo.setTNum(tNum);
        service.updateTifo(tifo);
        System.out.println("Tifo修改成功,id:"+id);
    }
    @RequestMapping(value = "addTifo/{paperName}&&{type}&&{name}&&{tNum}")
    public void addTifo(@PathVariable String paperName, @PathVariable String type, @PathVariable String name, @PathVariable int tNum) {
        Tifo tifo = new Tifo();
        tifo.setPaperName(paperName);
        tifo.setType(type);
        tifo.setName(name);
        tifo.setTNum(tNum);
        service.addTifo(tifo);
        System.out.println("Tifo添加成功,tNum:"+tNum);
    }
    //T
    @RequestMapping(value = "selectT", produces = "text/json;charset=utf-8")
    public String selectT() throws Exception {
        List<T> t = service.selectT();
        if(t != null){
            String[] column = {"id", "tNum", "detail", "tImg", "solution", "analysis", "difficulty"};
            String data = ObjtoLayJson.ListtoJson(t, column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "deleteT/{id}")
    public void deleteT(@PathVariable int id) {
        service.deleteT(id);
        System.out.println("T删除成功,id:"+id);
    }
    @RequestMapping(value = "updateT/{id}&&{tNum}&&{detail}&&{tImg}&&{solution}&&{analysis}&&{difficulty}")
    public void updateT(@PathVariable int id, @PathVariable int tNum, @PathVariable String detail, @PathVariable String tImg, @PathVariable String solution, @PathVariable String analysis, @PathVariable int difficulty) {
        T t = new T();
        t.setId(id);
        t.setTNum(tNum);
        t.setDetail(detail);
        t.setTImg(tImg);
        t.setSolution(solution);
        t.setAnalysis(analysis);
        t.setDifficulty(difficulty);
        service.updateT(t);
        System.out.println("T修改成功,id:"+id);
    }
    @RequestMapping(value = "addT/{tNum}&&{detail}&&{tImg}&&{solution}&&{analysis}&&{difficulty}")
    public void addT(@PathVariable int tNum, @PathVariable String detail, @PathVariable String tImg, @PathVariable String solution, @PathVariable String analysis, @PathVariable int difficulty) {
        T t = new T();
        t.setTNum(tNum);
        t.setDetail(detail);
        t.setTImg(tImg);
        t.setSolution(solution);
        t.setAnalysis(analysis);
        t.setDifficulty(difficulty);
        service.addT(t);
        System.out.println("T添加成功,tNum:"+tNum);
    }
    //chat
    @RequestMapping(value = "selectChat", produces = "text/json;charset=utf-8")
    public String selectChat() throws Exception {
        List<Chat> chat = service.selectChat();
        if (chat!=null){
            String[] column = {"id","aM","aName","aT","friend"};
            String data = ObjtoLayJson.ListtoJson(chat,column);
            //System.out.println(data);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "selectSingleChat/{getter}&&{sender}", produces = "text/json;charset=utf-8")
    public String selectSingleChat(@PathVariable String getter,@PathVariable String sender){
        List<Chat> chat = service.selectSingleChat(sender,getter);
        if (chat!=null){
            String data = JSON.toJSONString(chat);
            return data;
        }else{
            return null;
        }
    }
    @RequestMapping(value = "selectSingleChat1/{getter}&&{sender}", produces = "text/json;charset=utf-8")
    public String selectSingleChat1(@PathVariable String getter,@PathVariable String sender){
        List<Chat> chat = service.selectSingleChat(getter,sender);
        if (chat!=null){
            String data = JSON.toJSONString(chat);
            return data;
        }else{
            return null;
        }
    }
    @ResponseBody
    @RequestMapping(value = "addChat", method = RequestMethod.GET)
    public void addChat(@RequestParam("aM") String aM,@RequestParam("aName") String aName,@RequestParam("aT") String aT,@RequestParam("friend") String friend){
        Chat chat = new Chat();
        chat.setAM(aM);
        chat.setAName(aName);
        chat.setAT(aT);
        chat.setFriend(friend);
        service.addChat(chat);
        System.out.println(aName+":"+aM+","+aT+",to:"+friend);
    }

}
