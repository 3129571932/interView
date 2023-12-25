package com.hxc.interview.consoleservice.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class QuestionController {

    @Resource
    private QuestionService questionService;

    /**
     * 拿到所有的专业
     * @return
     */
    @GetMapping("/getAllQuestions")
    public ServiceResult getAllQuestions() {
        return questionService.getAllQuestions();
    }

}
