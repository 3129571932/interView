package com.hxc.interview.paperservice.dao;

import com.hxc.interView.common.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> getAllCourses();
}
