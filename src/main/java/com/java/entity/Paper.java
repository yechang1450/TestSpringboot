package com.java.entity;

public class Paper {

    private int id;

    private String course;

    private String type;

    private String name;

    private int time;

    private String paperStatus;

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"course\":\""+course+"\",\"type\":\""+type+"\",\"name\":\""+name+"\",\"time\":"+time+",\"paperStatus\":"+paperStatus+"}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus;
    }
}
