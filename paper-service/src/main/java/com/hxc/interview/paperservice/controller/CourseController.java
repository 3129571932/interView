package com.hxc.interview.paperservice.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.paperservice.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CourseController {

    @Resource
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public ServiceResult getAllCourses() {
        return courseService.getAllCourses();
    }

}
