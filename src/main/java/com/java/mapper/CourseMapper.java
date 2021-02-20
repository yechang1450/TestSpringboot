package com.java.mapper;

import com.java.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    List<Course> selectCourse();

    int deleteCourse(int id);

    int updateCourse(Course course);

    int addCourse(Course course);
}
