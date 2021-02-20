package com.java.entity;

public class Course {

    private int id;

    private String courseName;

    private String courseNum;

    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"courseName\":\""+courseName+"\",\"courseNum\":\""+courseNum+"\",\"name\":\""+grade+"\",\"time\":"+grade+"}";
    }
}
