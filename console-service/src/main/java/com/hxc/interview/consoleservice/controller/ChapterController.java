package com.hxc.interview.consoleservice.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.service.ChapterService;
import com.hxc.interview.consoleservice.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @GetMapping("/getAllChapters")
    public ServiceResult getAllChapters() {
        return chapterService.getAllChapters();
    }

}
