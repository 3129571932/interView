package com.hxc.interview.commonservice.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;
    private String userName;
    private String gender;
    private String address;
    private Integer idNo;
    private Integer age;
    private Integer phone;
    private Date registerDate;
    private Date last_login_success_date;
    private Integer login_pwd_error_times;
    private boolean userStatus;

    public User(){}

    public User(Integer id, String userName, String gender, String address, Integer idNo, Integer age, Integer phone, Date registerDate, Date last_login_success_date, Integer login_pwd_error_times, boolean userStatus) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.address = address;
        this.idNo = idNo;
        this.age = age;
        this.phone = phone;
        this.registerDate = registerDate;
        this.last_login_success_date = last_login_success_date;
        this.login_pwd_error_times = login_pwd_error_times;
        this.userStatus = userStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLast_login_success_date() {
        return last_login_success_date;
    }

    public void setLast_login_success_date(Date last_login_success_date) {
        this.last_login_success_date = last_login_success_date;
    }

    public Integer getLogin_pwd_error_times() {
        return login_pwd_error_times;
    }

    public void setLogin_pwd_error_times(Integer login_pwd_error_times) {
        this.login_pwd_error_times = login_pwd_error_times;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}
