package com.hxc.interView.common.entity;

public class Paper {

    private Integer paperId;
    private Integer questionId;
    private Integer questionSerial;
    private Integer status;

    public Paper() {
    }

    public Paper(Integer paperId, Integer questionId, Integer questionSerial, Integer status) {
        this.paperId = paperId;
        this.questionId = questionId;
        this.questionSerial = questionSerial;
        this.status = status;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionSerial() {
        return questionSerial;
    }

    public void setQuestionSerial(Integer questionSerial) {
        this.questionSerial = questionSerial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
