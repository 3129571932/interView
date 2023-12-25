package com.hxc.interview.consoleservice.service.impl;

import com.hxc.interView.common.entity.Course;
import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.dao.CourseMapper;
import com.hxc.interview.consoleservice.service.CourseService;
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
