package com.hxc.interView.common.entity;

public class Chapter {

    private Integer chapterId;
    private String chapterName;
    private Integer majorId;
    private Integer courseId;
    private int status;

    public Chapter() {}

    public Chapter(Integer chapterId, String chapterName, Integer majorId, Integer courseId, int status) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.majorId = majorId;
        this.courseId = courseId;
        this.status = status;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
