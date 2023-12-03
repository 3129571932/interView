package com.hxc.interview.userservice.service;


import com.hxc.interView.entity.User;
import com.hxc.interView.result.ServiceResult;

public interface UserService {

    ServiceResult getUserByCondition(User user);

    ServiceResult addUser(User user);
}
