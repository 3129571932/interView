package com.hxc.interView.entity;

public class Question {

    private Integer questionId;
    private String content;
    private String answer;
    private Integer majorId;
    private Integer courseId;
    private Integer chapterId;
    private int status;

    public Question() {}

    public Question(Integer questionId, String content, String answer, Integer majorId, Integer courseId, Integer chapterId, int status) {
        this.questionId = questionId;
        this.content = content;
        this.answer = answer;
        this.majorId = majorId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.status = status;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
