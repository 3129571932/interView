package com.hxc.interview.consoleservice.dao;

import com.hxc.interView.common.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> getAllQuestions();
}
