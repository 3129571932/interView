package com.hxc.interview.paperservice.service.impl;

import com.hxc.interView.common.entity.Course;
import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.paperservice.dao.CourseMapper;
import com.hxc.interview.paperservice.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public ServiceResult getAllCourses() {
        List<Course> courseList = courseMapper.getAllCourses();
        return ServiceResult.success(200, "查询成功", courseList);
    }
}
