package com.java.entity;

public class User {

    private Integer id;

    private String userName;

    private String passWord;

    private String idCard;

    private Integer grade;

    private String email;

    private String realName;

    private String personShow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPersonShow() {
        return personShow;
    }

    public void setPersonShow(String personShow) {
        this.personShow = personShow;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"userName\":\""+userName+"\",\"passWord\":\""+passWord+"\",\"idCard\":\""+idCard+"\",\"grade\":"+grade+",\"email\":\""+email+"\",\"realName\":\""+realName+"\",\"personShow\":\""+personShow+"\"}";
    }
}
