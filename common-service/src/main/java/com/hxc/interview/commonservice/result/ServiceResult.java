package com.hxc.interview.commonservice.result;

public class ServiceResult {

    private Integer code;
    private String messsage;
    private Object date;

    public static ServiceResult success(Integer code, String  messsage, Object date) {
        return new ServiceResult(code, messsage, date);
    }

    public static ServiceResult error(Integer code, String  messsage, Object date) {
        return new ServiceResult(code, messsage, date);
    }

    public ServiceResult() {}

    public ServiceResult(Integer code, String messsage, Object date) {
        this.code = code;
        this.messsage = messsage;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
