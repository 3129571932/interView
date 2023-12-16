package com.hxc.interView.common.entity;

import java.util.List;

public class PaperVo{

    private Integer paperId;
    private List<Question> questions;

    private Integer status;

    public PaperVo() {
    }

    public PaperVo(Integer paperId, List<Question> questions, Integer status) {
        this.paperId = paperId;
        this.questions = questions;
        this.status = status;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
