package com.hxc.interView.common.entity;

public class Major {

    private Integer majorId;
    private String majorName;
    private int status;

    public Major(){}

    public Major(Integer majorId, String majorName, int status) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.status = status;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
