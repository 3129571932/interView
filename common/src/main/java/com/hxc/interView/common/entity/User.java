package com.hxc.interView.common.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;
    private String userName;
    private String gender;
    private String address;
    private String idNo;
    private Integer age;
    private String phone;
    private Date registerDate;
    private Date last_login_success_date;
    private Integer login_pwd_error_times;
    private Integer userStatus;
    private String password;
    private String key;
    private String iv;
    private String email;

    public User(){}

    public User(Integer id, String userName, String gender, String address, String idNo, Integer age, String phone, Date registerDate, Date last_login_success_date, Integer login_pwd_error_times, Integer userStatus, String password, String key, String iv, String email) {
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
        this.password = password;
        this.key = key;
        this.iv = iv;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
