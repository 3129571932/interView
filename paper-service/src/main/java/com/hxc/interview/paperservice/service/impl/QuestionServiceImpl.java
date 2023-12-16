package com.hxc.interview.paperservice.service.impl;

import com.hxc.interView.common.entity.Question;
import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.paperservice.dao.QuestionMapper;
import com.hxc.interview.paperservice.service.QuestionService;

import javax.annotation.Resource;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public ServiceResult getAllQuestions() {
        List<Question> questionList = questionMapper.getAllQuestions();
        return ServiceResult.success(200, "查询成功", questionList);
    }
}
