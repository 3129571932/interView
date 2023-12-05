package com.hxc.interView.entity;

public class Course {

    private Integer courseId;
    private String courseName;
    private Integer majorId;
    private String status;

    public Course(){}

    public Course(Integer courseId, String courseName, Integer majorId, String status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.majorId = majorId;
        this.status = status;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
